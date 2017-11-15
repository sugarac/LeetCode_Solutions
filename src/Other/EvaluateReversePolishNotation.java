package Other;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    /**
     * Solution1: Stack O(n); O(n)
     * Traverse the array, use a stack to store each operand.
     * If find an operator, pop two operands from stack and calculate the result, then push result to stack.
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String operators = "+-*/";
        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }

            int a = stack.pop();
            int b = stack.pop();
            if (token.equals("+")) {
                stack.push(b + a);
            } else if (token.equals("-")) {
                stack.push(b - a);
            } else if (token.equals("*")) {
                stack.push(b * a);
            } else {
                stack.push(b / a);
            }
        }
        return stack.pop();
    }
}
