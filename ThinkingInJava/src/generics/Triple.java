package generics;

public class Triple<A, B, C> extends Tuple<A, B> {

    public C third;

    public Triple(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + third;
    }

}
