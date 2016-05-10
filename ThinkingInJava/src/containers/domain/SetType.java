package containers.domain;

public class SetType {

    protected int i;

    public SetType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SetType) {
            SetType st = (SetType) o;
            return i == st.i;
        }
        return false;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
