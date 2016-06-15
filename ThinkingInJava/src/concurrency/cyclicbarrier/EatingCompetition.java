package concurrency.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EatingCompetition {

    private static final int WINNING_COUNT = 50;

    private final ExecutorService exec = Executors.newCachedThreadPool();

    private List<Eater> eaters = new ArrayList<>();
    private CyclicBarrier barrier;

    public EatingCompetition(int numEaters, int pause) {
        class BarrierAction implements Runnable {
            @Override
            public void run() {
                printGuideLine();
                printEaterProgress();
                checkForWinner();
            }

            private void printGuideLine() {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < WINNING_COUNT; i++) {
                    sb.append("=");
                }
                System.out.println(sb);
            }

            private void printEaterProgress() {
                for (Eater eater : eaters) {
                    System.out.println(eater.eat());
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch(InterruptedException e) {
                    System.out.println("BarrierAction interrupted: " + e);
                }
            }

            private void checkForWinner() {
                boolean hasWinner = false;
                for (Eater eater : eaters) {
                    if (eater.getNumEaten() >= WINNING_COUNT) {
                        System.out.println(eater + " is the winner!");
                        exec.shutdownNow();
                        hasWinner = true;
                    }
                }
                if (hasWinner = true) {
                    return;
                }
            }
        }

        barrier = new CyclicBarrier(numEaters, new BarrierAction());
        for (int i = 0; i < numEaters; i++) {
            Eater eater = new Eater(barrier);
            eaters.add(eater);
        }
    }

    public void startCompetition() {
        for (Eater eater : eaters) {
            exec.execute(eater);
        }
    }

    public static void main(String[] args) {
        int eaters = 5;
        int pause = 20;

        EatingCompetition comp = new EatingCompetition(eaters, pause);
        comp.startCompetition();
    }
}
