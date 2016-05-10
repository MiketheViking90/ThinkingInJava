package generics;

import generics.domain.Automobile;
import lombok.Getter;
import lombok.Setter;

public class Holder2 {

    @Setter @Getter public Object a;

    public Holder2(Object a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile) h2.getA();

        h2.setA("Some string");
        String s = (String) h2.getA();
        System.out.println(s);

        h2.setA(1);
        int x = (int) h2.getA();
        System.out.println(x);
    }
}
