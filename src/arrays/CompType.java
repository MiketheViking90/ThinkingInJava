package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import arrays.domain.CompTypeComparator;
import lombok.Getter;

public class CompType implements Comparable<CompType> {

    private static final String DISPLAY_FORMAT = "(%d, %d)";
    private static int count = 1;

    @Getter private int i;
    @Getter private int j;

    public CompType(int a, int b) {
        i = a;
        j = b;
    }

    @Override
    public String toString() {
        return String.format(DISPLAY_FORMAT, i, j);
    }

    @Override
    public int compareTo(CompType compared) {
        if (i < compared.i) {
            return -1;
        } else if (i == compared.i) {
            return 0;
        } else {
            return 1;
        }
    }

    public static CompType[] generate(int n) {
        Random rand = new Random(47);
        CompType[] rv = new CompType[n];

        for (int i = 0; i < n; i++) {
            rv[i] = new CompType(rand.nextInt(100), rand.nextInt(100));
        }

        return rv;
    }

    public static void main(String[] args) {
        CompType[] vals = CompType.generate(10);
        System.out.println(Arrays.toString(vals));

        Arrays.sort(vals);
        System.out.println(Arrays.toString(vals));

        Arrays.sort(vals, Collections.reverseOrder());
        System.out.println(Arrays.toString(vals));


        Arrays.sort(vals, new CompTypeComparator());
        System.out.println(Arrays.toString(vals));
    }

}
