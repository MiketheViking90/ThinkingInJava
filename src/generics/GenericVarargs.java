package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {

    public static <T> List<T> makeList(T... args) {
        List<T> res = new ArrayList<>();

        for (T t : args) {
            res.add(t);
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> strings = makeList("I", " ", "am", " ", "Kefka");
        System.out.println(strings);
    }
}
