package generics;

import java.util.Iterator;

public class FibonnacciIterator implements Iterator<Integer> {

    private int[] fibSeq;
    private int index = 0;

    public FibonnacciIterator(int[] nums) {
        fibSeq = nums;
    }

    @Override
    public boolean hasNext() {
        return index < fibSeq.length;
    }

    @Override
    public Integer next() {
        return fibSeq[index++];
    }
}
