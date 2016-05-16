package concurrency;

import concurrency.domain.InnerRunnable1;
import concurrency.domain.InnerRunnable2;
import concurrency.domain.InnerThread1;
import concurrency.domain.InnerThread2;

public class ThreadVariations {

    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod");
    }
}
