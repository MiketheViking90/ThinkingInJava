package arrays;

public class ParameterizedArrayType {

    class ClassParam<T> {
        public T[] foo(T[] arg) {
            return arg;
        }
    }

    class MethodParam {
        public <T> T[] foo(T[] arg) {
            return arg;
        }
    }

    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
    }
}
