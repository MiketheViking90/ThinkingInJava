package generics;

public class LinkedListStack<T> {

    private class Node {
        T item;
        Node next;

        Node() {
            item = null;
            next = null;
        }

        Node(T u, Node next) {
            this.item = u;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node top = new Node();

    public void push(T t) {
        top = new Node(t, top);
    }

    public T pop() {
        T popped = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return popped;
    }

    public static void main(String[] args) {
        LinkedListStack<String> stack = new LinkedListStack<>();

        for (String s : "Phasers on stun!".split(" ")) {
            stack.push(s);
        }

        String s;

        while ((s = stack.pop()) != null) {
            System.out.println(s);
        }
    }
}
