package containers.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import containers.domain.Countries;

public class FillList {

    public static void main(String[] args) {
        ArrayList<String> arrayCountries = new ArrayList<>(Countries.names());
        LinkedList<String> linkedCountries = new LinkedList<>(Countries.names());
        System.out.println(arrayCountries);
        System.out.println(linkedCountries);

        shuffle(arrayCountries, linkedCountries);
        System.out.println(arrayCountries);
        System.out.println(linkedCountries);

        shuffle(arrayCountries, linkedCountries);
        System.out.println(arrayCountries);
        System.out.println(linkedCountries);
    }

    private static void shuffle(ArrayList<String> arrayCountries, LinkedList<String> linkedCountries) {
        Collections.shuffle(arrayCountries);
        Collections.shuffle(linkedCountries);
        System.out.println();
    }
}
