package concurrency.medirestaurant;

import lombok.Getter;

public class Table {

    @Getter private boolean isClean;

    public Table() {
        isClean = false;
    }

    public void cleanTable() {
        isClean = true;
    }

    public void seatGuests() {
        isClean = false;
    }
}
