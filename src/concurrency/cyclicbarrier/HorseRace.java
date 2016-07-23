package concurrency.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HorseRace {

    private static final int FINISH_LINE = 50;

    private List<Horse> horses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public HorseRace(int numHorses, int pause) {

        class HorseRaceBarrierAction implements Runnable {
            @Override
            public void run() {
                printLane();
                printHorseProgress();
                checkWinner();
            }

            private void printLane() {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    sb.append("=");
                }
                System.out.println(sb);
            }

            private void printHorseProgress() {
                for (Horse horse : horses) {
                    System.out.println(horse.tracks());
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch(InterruptedException e) {
                    System.out.println("BarrierAction interrupted: " + e);
                }

            }

            private void checkWinner() {
                boolean hasWinner = false;
                for (Horse horse : horses) {
                    if (horse.getStrides() >= FINISH_LINE) {
                        hasWinner = true;
                        System.out.println(horse + " won!");
                        exec.shutdownNow();
                    }
                }
                if (hasWinner) {
                    return;
                }
            }
        }

        barrier = new CyclicBarrier(numHorses, new HorseRaceBarrierAction());
        for (int i = 0; i < numHorses; i++) {
            Horse horse = new Horse(barrier);
            System.out.println(horse);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorses = 7;
        int pause = 20;

        new HorseRace(nHorses, pause);
    }

}
