package generics;

import generics.domain.Automobile;
import lombok.Getter;

public class Holder1 {

    @Getter private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

}
