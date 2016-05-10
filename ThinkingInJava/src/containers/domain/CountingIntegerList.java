package containers.domain;

import java.util.AbstractList;

public class CountingIntegerList extends AbstractList<Integer> {

    private int size;

    public CountingIntegerList(int size) {
        if (size < 0) {
            size = 0;
        } else {
            this.size = size;
        }
    }

    @Override
    public Integer get(int index) {
        return Integer.valueOf(index);
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CountingIntegerList list = new CountingIntegerList(30);
        System.out.println(list);
    }

}
