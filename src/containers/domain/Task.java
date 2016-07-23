package containers.domain;

import lombok.Getter;
import lombok.Setter;

public class Task implements Comparable<Task> {

    @Getter private String name;
    @Setter @Getter private int priority;

    public Task(String name) {
        this.name = name;
        priority = 2;
    }

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task t) {
        if (priority > t.priority) {
            return 1;
        } else if (priority == t.priority) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
