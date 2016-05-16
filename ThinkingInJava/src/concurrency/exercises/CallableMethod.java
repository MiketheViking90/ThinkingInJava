package concurrency.exercises;

public class CallableMethod {

    private Thread t;
    private String name;

    public CallableMethod(String name, int n) {
        this.name = name;
        runTask(n);
    }

    private void runTask(int n) {
        if (t == null) {
            t = new Thread(name) {
                int[] fibs = new int[n];
                private int index = 0;

                @Override
                public void run() {
                    while (true) {
                        if (index < 2) {
                            fibs[index] = 1;
                        } else {
                            fibs[index] = (fibs[index - 1] + fibs[index - 2]);
                        }
                        System.out.println(this);
                        if (index++ == (n - 1)) {
                            return;
                        }
                    }
                }

                @Override
                public String toString() {
                    return name + ", " + index + ": " + fibs[index];
                }
            };
        }
        t.start();
    }

    public static void main(String[] args) {
        CallableMethod cm1 = new CallableMethod("CM1", 4);
        CallableMethod cm2 = new CallableMethod("CM2", 12);
        CallableMethod cm3 = new CallableMethod("CM3", 15);
        CallableMethod cm4 = new CallableMethod("CM4", 8);
        CallableMethod cm5 = new CallableMethod("CM5", 7);
    }
}
