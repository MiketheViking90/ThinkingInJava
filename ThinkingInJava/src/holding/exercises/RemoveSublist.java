package holding.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import holding.domain.Pet;

public class RemoveSublist {

    public static void main(String[] args) {
        List<Pet> petsArray = new ArrayList<>();
        List<Pet> petsLinked = new LinkedList<>();

        removeSublist(petsArray);
    }

    private static List<Pet> fill(List<Pet> list) {
        Pet pet1 = new Pet("Rufus");
        Pet pet2 = new Pet("Apollo");
        Pet pet3 = new Pet("Varzea");
        Pet pet4 = new Pet("Dawson");
        Pet pet5 = new Pet("Ruby");

        Collections.addAll(list, pet1, pet2, pet3, pet4, pet5);
        return list;
    }

    private static void removeSublist(List<Pet> petsList) {
        fill(petsList);
        System.out.println(petsList);
        List<Pet> subList = petsList.subList(2, 4);
        petsList.removeAll(subList);
        System.out.println(petsList);
    }
}
