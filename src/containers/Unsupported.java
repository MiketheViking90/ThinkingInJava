package containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Unsupported {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L M N O P".split(" "));
        test("Modifiable copy ", new ArrayList<String>(list));
        test("Arrays.asList() ", list);
        test("Collections.unmodifiableList() ", Collections.unmodifiableList(list));
    }

    private static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);

        //Copy sublist
        Collection<String> c2 = new ArrayList<>(subList);
        try {
            c.retainAll(c2);
            c.clear();
            c.add("X");
            c.addAll(c2);
            c.remove("C");
        } catch (Exception e) {
            System.out.println("Colletion unsupported");
        }

        try {
            list.set(0, "X");
        } catch (Exception e) {
            System.out.println("List unsupported");
        }
    }
}
