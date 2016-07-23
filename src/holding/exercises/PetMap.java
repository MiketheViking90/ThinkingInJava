package holding.exercises;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import holding.domain.Pet;

public class PetMap {

    public static void main(String[] args) {
        Map<String, Pet> pm = new HashMap<>();
        pm.put("Fuzzy", new Pet("Fuzzy"));
        pm.put("Drake", new Pet("Drake"));
        pm.put("Miles", new Pet("Miles"));
        pm.put("Bill", new Pet("Bill"));
        pm.put("Roth", new Pet("Roth"));

        Iterator<String> keyIt = pm.keySet().iterator();
        while (keyIt.hasNext()) {
            String key = keyIt.next();
            System.out.println(pm.get(key));
        }
    }
}
