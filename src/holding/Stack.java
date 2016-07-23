package holding;

import java.util.LinkedList;

public class Stack<T> {

    private LinkedList<T> storage = new LinkedList<>();

    public void push(T v) {
        storage.add(v);
    }

    public T pop() {
        return storage.removeLast();
    }

    public T peek() {
        return storage.getLast();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    @Override
    public String toString() {
        return storage.toString();
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }

        System.out.println(stack);
    }

}
