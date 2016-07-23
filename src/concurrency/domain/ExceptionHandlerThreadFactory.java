package concurrency.domain;

import java.util.concurrent.ThreadFactory;

public class ExceptionHandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this.getClass().getSimpleName() + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created Thread: " + t   );
        t.setUncaughtExceptionHandler(new CustomUncaughtExceptionHandler());
        System.out.println("eh: " + t.getUncaughtExceptionHandler().getClass().getSimpleName());
        return t;
    }

}
