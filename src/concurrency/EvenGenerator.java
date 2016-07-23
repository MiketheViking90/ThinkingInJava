package concurrency;

public class EvenGenerator extends IntGenerator {

    private int currentVal = 0;

    @Override
    public int next() {
        ++currentVal;
        ++currentVal;
        return currentVal;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }

}
