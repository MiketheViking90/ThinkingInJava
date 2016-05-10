package holding.domain;

import java.util.Collection;
import java.util.Collections;

import lombok.Getter;

public class Pet implements Comparable {

    private static int counter;

    @Getter protected final String name;
    @Getter protected final int id;

    public Pet(String name) {
        this.name = name;
        id = counter++;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pet) {
            Pet compareToPet = (Pet) obj;
            return name.equals(compareToPet.getName()) &&
                    id == compareToPet.id;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Pet) {
            Pet p = (Pet) o;
            return name.compareTo(((Pet) o).name);
        }
        return 0;
    }

    public static Collection<Pet> fill(Collection<Pet> c) {
        Pet pet1 = new Pet("Rufus");
        Pet pet2 = new Pet("Apollo");
        Pet pet3 = new Pet("Varzea");
        Pet pet4 = new Pet("Dawson");
        Pet pet5 = new Pet("Ruby");

        Collections.addAll(c, pet1, pet2, pet3, pet4, pet5);
        return c;
    }

}
