package generics;

public class Quadruple<A, B, C, D> extends Triple<A, B, C>{

    public D fourth;

    public Quadruple(A a, B b, C c, D d) {
        super(a, b, c);
        fourth = d;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + fourth;
    }
}
