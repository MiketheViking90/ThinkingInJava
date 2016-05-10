package holding;

import java.util.HashMap;
import java.util.Map;

import holding.domain.Pet;

public class PetMap {

    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<>();
        petMap.put("My Cat", new Pet("cat"));
        petMap.put("My Dog", new Pet("dog"));
        petMap.put("My Hamster", new Pet("hamster"));
        System.out.println(petMap);

        Pet dog = petMap.get("My Dog");
        System.out.println(dog);
        System.out.println(petMap.containsKey("My Dog"));
        System.out.println(petMap.containsValue(dog));
    }
}
