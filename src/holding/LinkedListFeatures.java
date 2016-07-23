package holding;

import java.util.LinkedList;

import holding.domain.Pet;

public class LinkedListFeatures {

    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<>();
        Pet.fill(pets);

        print(pets.getFirst());
        print(pets.element());
        print(pets.peek());

        System.out.println();

        print(pets.remove());
        print(pets.removeFirst());
        print(pets.poll());

        pets.addFirst(new Pet("Bill"));
        pets.offer(new Pet("Blackfoot"));
        print(pets);
        pets.add(new Pet("Varzea"));
        print(pets);

    }

    private static void print(Object obj) {
        System.out.println(obj);
    }
 }
