package holding.domain;

import lombok.Getter;

public class Apple {

    private static long counter;

    @Getter private final long id = counter++;

}
