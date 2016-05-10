package holding;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import holding.domain.Pet;

public class ListIteration {

    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        Pet.fill(pets);

        ListIterator<Pet> listIt = pets.listIterator();
        while (listIt.hasNext()) {
            System.out.println(listIt.next() + ", "
                    + listIt.nextIndex() + ", " + listIt.previousIndex());
        }

        while (listIt.hasPrevious()) {
            System.out.println(listIt.previous() + ", "
                    + listIt.nextIndex() + ", " + listIt.previousIndex());
        }

        listIt = pets.listIterator();
        while (listIt.hasNext()) {
            listIt.next();
            listIt.set(new Pet("Bill"));
        }
        System.out.println(pets);
    }
}
