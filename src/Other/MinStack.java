package Other;

import java.util.Stack;

public class MinStack {
    /**
     * Solution1: Stack O(1); O(n)
     * Use a stack to store each element and each old minimum, a variable “min” to record current minimum.
     * For push, if pushed element x <= min, push x into stack and update min to x.
     * For pop, pop from stack and then check if popped element = min, if equal, pop again (y) and update min to y.
     */
    Stack<Integer> stack;
    int min;

    //    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) { //= is important because we need to store every old minimum
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
