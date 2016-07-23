package concurrency.notifyvsnotifyall;

public class Blocker {

    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println(Thread.currentThread());
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void sendNotify() {
        notify();
    }

    public void sendNotifyAll() {
        notifyAll();
    }

}
