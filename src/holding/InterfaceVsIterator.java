package holding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import holding.domain.Pet;

public class InterfaceVsIterator {

    public static void main(String[] args) {
        List<Pet> petList = new ArrayList<>();
        Pet.fill(petList);
        Set<Pet> petSet = new HashSet<>(petList);

        Map<String, Pet> petMap = new LinkedHashMap<>();
        petMap = fillMap(petList, petMap);
        display(petList);
        display(petSet);
        display(petList.iterator());
        display(petSet.iterator());

        System.out.println(petMap);
        System.out.println(petMap.keySet());

        display(petMap.values());
        display(petMap.values().iterator());
    }

    public static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p + " ");
        }
        System.out.println();
    }

    public static void display(Collection<Pet> pets) {
        for (Pet p : pets) {
            System.out.print(p + " ");
        }
        System.out.println();
    }

    private static Map<String, Pet> fillMap(List<Pet> petList, Map<String, Pet> petMap) {
        for (Pet p : petList) {
            petMap.put(p.getName(), p);
        }
        return petMap;
    }
}
