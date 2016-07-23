package arrays.domain;

import java.util.Comparator;

import arrays.CompType;

public class CompTypeComparator implements Comparator<CompType>{

    @Override
    public int compare(CompType o1, CompType o2) {
        if (o1.getJ() > o2.getJ()) {
            return 1;
        } else if (o1.getJ() == o2.getJ()) {
            return 0;
        } else {
            return -1;
        }
    }

}
