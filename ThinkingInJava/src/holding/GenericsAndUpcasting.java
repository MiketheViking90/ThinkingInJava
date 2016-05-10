package holding;

import java.util.ArrayList;
import java.util.List;

import holding.domain.Apple;
import holding.domain.Braeburn;
import holding.domain.Fuji;
import holding.domain.GrannySmith;

public class GenericsAndUpcasting {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new GrannySmith());
        apples.add(new Fuji());
        apples.add(new Braeburn());

        for (Apple apple : apples) {
            System.out.println(apple);
        }
    }

}
