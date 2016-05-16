package concurrency.domain;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InnerCallable1 {

    private ExecutorService exec = Executors.newCachedThreadPool();
    private String name;
    private Inner inner;

    public InnerCallable1(String name, int n) {
        this.name = name;
        inner = new Inner(n);
    }

    private class Inner implements Callable<Integer> {
        private int[] values;
        private int index = 0;
        private int size;

        public Inner(int n)  {
            size = n;
            values = new int[size];
            Future<Integer> res = exec.submit(this);
            try {
                System.out.println(res.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
            }
        }

        @Override
        public Integer call() throws Exception {
            while (index < size) {
                if (index < 2) {
                    values[index] = 1;
                } else {
                    values[index] = (values[index - 1] + values[index - 2]);
                }
                System.out.println(name + ", " + index + ": " + values[index]);
                index++;
            }

            return values[values.length - 1];
        }
    }

    public static void main(String[] args) {
        InnerCallable1 ic1 = new InnerCallable1("IC1", 12);
        InnerCallable1 ic2 = new InnerCallable1("IC2", 9);
        InnerCallable1 ic3 = new InnerCallable1("IC3", 4);
        InnerCallable1 ic4 = new InnerCallable1("IC4", 15);
    }
}
