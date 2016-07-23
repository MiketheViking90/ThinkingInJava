package holding.exercises;

import java.util.PriorityQueue;

import holding.domain.Blank;

public class PriorityQueueBlank {

    public static void main(String[] args) {
        PriorityQueue<Blank> blanks = new PriorityQueue<>();
        for (int i = 0; i < 5; i++) {
            blanks.add(new Blank());
        }
    }
}
