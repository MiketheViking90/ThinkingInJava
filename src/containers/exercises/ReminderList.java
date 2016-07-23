package containers.exercises;

import java.util.PriorityQueue;
import java.util.Queue;

import containers.domain.Task;

public class ReminderList {

    private Queue<Task> tasks = new PriorityQueue<>();

    public void add(Task t) {
        tasks.offer(t);
    }

    public void add(Task... args) {
        for (Task t : args) {
            tasks.add(t);
        }
    }

    public Task remove() {
        return tasks.remove();
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public static void main(String[] args) {
        ReminderList rl = new ReminderList();
        Task t1 = new Task("laundry");
        Task t2 = new Task("work", 3);
        Task t3 = new Task("walk", 1);

        rl.add(t1, t2, t3);
        while (!rl.isEmpty()) {
            System.out.println(rl.remove());
        }
    }
}
