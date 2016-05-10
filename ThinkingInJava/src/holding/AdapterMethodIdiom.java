package holding;

import java.util.Arrays;
import java.util.List;

public class AdapterMethodIdiom {

    public static void main(String[] args) {

        List<String> ary = Arrays.asList("A", "B", "C", "D", "E");
        ReversibleArrayList<String> revList = new ReversibleArrayList<String>(ary);

        for (String s : revList) {
            System.out.println(s);
        }

        for (String s : revList.reversed()) {
            System.out.println(s);
        }
    }
}
