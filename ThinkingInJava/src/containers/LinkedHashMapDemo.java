package containers;

import java.util.LinkedHashMap;

import containers.domain.CountingMapData;

public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>(new CountingMapData(9));
        System.out.println(lhm);

        LinkedHashMap<Integer, String> lhm1 = new LinkedHashMap<>(16, 0.75f, true);
        lhm1.putAll(new CountingMapData(9));
        System.out.println(lhm1);

        for (int i = 0; i < 5; i++) {
            lhm1.get(i);
        }
        System.out.println(lhm1);
        lhm1.get(0);
        System.out.println(lhm1);
    }
}
