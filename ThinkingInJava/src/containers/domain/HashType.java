package containers.domain;

public class HashType extends SetType {

    public HashType(int i) {
        super(i);
    }

    @Override
    public int hashCode() {
        return i;
    }
}
