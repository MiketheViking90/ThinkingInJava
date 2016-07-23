package containers.domain;

public class TreeType extends SetType implements Comparable<TreeType> {

    public TreeType(int i) {
        super(i);
    }

    @Override
    public int compareTo(TreeType o) {
        if (i > o.i) {
            return -1;
        } else if (i == o.i) {
            return 0;
        } else {
            return 1;
        }
    }

}
