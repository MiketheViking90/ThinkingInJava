package containers;

import java.util.PriorityQueue;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {

    private static final long serialVersionUID = 1L;

    public void add(String td, char pri, int sec) {
        ToDoItem item = new ToDoItem(td, pri, sec);
        super.add(item);
    }

    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(String td, char pri, int sec) {
            item = td;
            primary = pri;
            secondary = sec;
        }

        @Override
        public int compareTo(ToDoItem arg) {
            if (primary > arg.primary) {
                return 1;
            } else if (primary == arg.primary) {
                return compareSecondary(arg.secondary);
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return Character.toString(primary) + secondary + ": " + item;
        }

        private int compareSecondary(int val) {
            if (secondary > val) {
                return 1;
            } else if (secondary == val) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        list.add("Empty trash", 'C', 4);
        list.add("Feed dog", 'B', 2);
        list.add("Mow lawn", 'A', 1);
        list.add("Water lawn", 'B', 4);
        list.add("Feed cat", 'B', 1);

        while (!list.isEmpty()) {
            System.out.println(list.remove());
        }
    }
}
