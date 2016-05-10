package generics;

import generics.domain.Automobile;
import lombok.Getter;
import lombok.Setter;

public class Holder3<T> {

    @Getter @Setter private T item;

    public Holder3(T item) {
        this.item = item;
    }

    public static void main(String[] args) {
        Holder3 h3 = new Holder3(new Automobile());
        Automobile item1 = (Automobile) h3.getItem();

        h3.setItem("asdfasfd");
        String s = (String) h3.getItem();
        System.out.println(s);

        Holder3<Automobile> h3Param = new Holder3<>(new Automobile());
        Automobile item2 = h3Param.getItem();

    }

}
