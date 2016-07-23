package containers.domain;

public class StringAddress {

    private String str;

    public StringAddress(String s) {
        str = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + str;
    }

}
