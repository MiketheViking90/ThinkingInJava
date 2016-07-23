package generics;

public class GenericMethods {

    public <T, U, V> void foo(T t, U u, V v) {
        System.out.println(t.getClass().getSimpleName());
        System.out.println(u.getClass().getSimpleName());
        System.out.println(v.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.foo(new Integer(12), 123.2, "blah");
    }
}
