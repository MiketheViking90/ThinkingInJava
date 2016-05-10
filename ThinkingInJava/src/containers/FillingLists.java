package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import containers.domain.StringAddress;

public class FillingLists {

    public static void main(String[] args) {
        List<StringAddress> addresses = new ArrayList<>(
                Collections.nCopies(4, new StringAddress("221b Baker Street")));
        System.out.println(addresses);

        Collections.fill(addresses, new StringAddress("420 Paper Street"));
        System.out.println(addresses);
    }
}
