package holding;

import java.util.Arrays;

public class ArrayIsNotIterable {

    private static <T> void test (Iterable<T> ib) {
        for (T t : ib) {
            System.out.println(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));

        String[] strs = {"A", "B", "C"};
        for (String s : strs) {
            System.out.println(s);
        }
        test(Arrays.asList(strs));
    }
}
