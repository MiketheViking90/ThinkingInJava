package holding.exercises;

import java.util.Stack;

public class StackExpression {

    private static final String EXPR = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s--";

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < EXPR.length()) {
            char c = EXPR.charAt(i);
            if (c == '+') {
                stack.push(EXPR.charAt(++i));
            } else if (c == '-') {
                System.out.println(stack.pop());
            }
            i++;
        }

    }

}
