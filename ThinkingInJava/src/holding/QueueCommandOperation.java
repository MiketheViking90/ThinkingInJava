package holding;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import holding.domain.QueueCommand;

public class QueueCommandOperation {

    public static void main(String[] args) {
        Queue<QueueCommand> q = setupQueue();

        Iterator<QueueCommand> it = q.iterator();
        while (it.hasNext()) {
            it.next().display();
        }
        System.out.println(q.peek());
        System.out.println(q.poll());
    }

    private static Queue<QueueCommand> setupQueue() {
        Queue<QueueCommand> q = new LinkedList<>();
        q.add(new QueueCommand("Ace"));
        q.add(new QueueCommand("Kit"));
        q.add(new QueueCommand("Iceman"));
        q.add(new QueueCommand("Dove"));
        q.add(new QueueCommand("Max"));
        q.add(new QueueCommand("Cash"));

        return q;
    }
}
