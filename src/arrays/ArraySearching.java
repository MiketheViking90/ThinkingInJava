package arrays;

import java.util.Arrays;
import java.util.Random;

public class ArraySearching {

    public static void main(String[] args) {
        Random rand = new Random(47);
        int[] ints = new int[100];
        for (int i = 0; i < 100; i++) {
            ints[i] = rand.nextInt(25);
        }
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));

        while (true) {
            int r = rand.nextInt(25);
            int index = Arrays.binarySearch(ints, r);
            if (index >= 0) {
                System.out.println("Found " + r + " at " + index);
            }
            break;
        }
    }
}
