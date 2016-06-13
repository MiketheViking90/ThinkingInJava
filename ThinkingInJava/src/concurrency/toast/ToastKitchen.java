package concurrency.toast;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ToastKitchen {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Toast> dryQueue = new LinkedBlockingQueue<>(),
                butteredQueue = new LinkedBlockingQueue<>(),
                jammedQueue = new LinkedBlockingQueue<>(),
                finishedQueue = new LinkedBlockingQueue<>();

        ExecutorService exec = Executors.newCachedThreadPool();
        Toaster toaster = new Toaster(dryQueue);
        Butterer butterer = new Butterer(dryQueue, butteredQueue);
        Jammer jammer = new Jammer(butteredQueue, jammedQueue);
        PeanutButterer peanutButterer = new PeanutButterer(jammedQueue, finishedQueue);
        Jellier jellier = new Jellier(jammedQueue, finishedQueue);
        Eater eater = new Eater(finishedQueue);

        exec.execute(toaster);
        exec.execute(butterer);
        exec.execute(jammer);
        exec.execute(peanutButterer);
        exec.execute(jellier);
        exec.execute(eater);

        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }

}
