package holding;

import java.util.ArrayList;

import holding.domain.Apple;

public class ApplesAndOrangesWithoutGenerics {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }

        for (int i = 0; i < apples.size(); i++) {
            Apple apple = apples.get(i);
            System.out.println(apple.getId());
        }

        for (Apple appl : apples) {
            System.out.println(appl.getId());
        }
    }

}
