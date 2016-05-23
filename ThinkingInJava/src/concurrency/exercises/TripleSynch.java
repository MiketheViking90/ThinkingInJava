package concurrency.exercises;

public class TripleSynch {

    private static int val = 0;

    public void f() {
        synchronized(this) {
            val++;
            val++;
            System.out.println("f(): " + val);
        }
    }

    public void g() {
        synchronized(this) {
            val++;
            val++;
            System.out.println("g(): " + val);
        }
    }

    public void h() {
        synchronized(this) {
            val++;
            val++;
            System.out.println("h(): " + val);
        }
    }

    public static void main(String[] args) {
        TripleSynch ts = new TripleSynch();

        for (int i = 0; i < 5; i++) {
            threadF(ts);
            ts.g();
            ts.h();
        }
    }

    private static void threadF(TripleSynch ts) {
        new Thread() {
            @Override
            public void run() {
                ts.f();
            }
        }.start();
    }

    private static void threadG(TripleSynch ts) {
        new Thread() {
            @Override
            public void run() {
                ts.g();
            }
        }.start();
    }

    private static void threadH(TripleSynch ts) {
        new Thread() {
            @Override
            public void run() {
                ts.h();
            }
        }.start();
    }
}
