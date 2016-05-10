package containers.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import generics.abst.Generator;

public class Government implements Generator<String> {

    private String[] words = ("strange women lying in ponds " +
            " distributing swords is no basis for a system of government").split(" ");
    private int index;

    @Override
    public String generate() {
        return words[index++];
    }

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>(
                new CollectionData<String>(new Government(), 10));
        set.addAll(CollectionData.list(new Government(), 10));
        System.out.println(set);
    }
}
