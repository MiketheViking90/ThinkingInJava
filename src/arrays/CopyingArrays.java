package arrays;

import java.util.Arrays;

import arrays.domain.BerylliumSphere;

public class CopyingArrays {

    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];

        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        System.out.println("i: " + Arrays.toString(i));
        System.out.println("j: " + Arrays.toString(j));

        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("i: " + Arrays.toString(i));
        System.out.println("j: " + Arrays.toString(j));


        BerylliumSphere[] spheres1 = {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};
        BerylliumSphere[] spheres2 = new BerylliumSphere[4];
        System.arraycopy(spheres1, 0, spheres2, 0, spheres1.length);
        System.out.println("spheres1: " + Arrays.toString(spheres1));
        System.out.println("spheres2: " + Arrays.toString(spheres2));

        spheres1[0] = new BerylliumSphere();
        System.out.println("spheres1: " + Arrays.toString(spheres1));
        System.out.println("spheres2: " + Arrays.toString(spheres2));
    }
}
