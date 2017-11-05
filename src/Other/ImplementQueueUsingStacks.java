package Other;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    /**
     * Solution1: Stack O(1), amortized time; O(n)
     * Use 2 stacks, one input stack, onto which we push the incoming elements, and one output stack, from which we peek/pop.
     * When peek/pop but the output stack is empty, move elements from input stack to output stack.
     */
    Stack<Integer> input;
    Stack<Integer> output;

    //    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        input = new Stack<>();
        output = new Stack<>();
    }

    //    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    //    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return output.pop();
    }

    //    /** Get the front element. */
    public int peek() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    //    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty() && output.empty();
    }

    //效率不行
//    Stack<Integer> stack1;
//    Stack<Integer> stack2;
//
//    /** Initialize your data structure here. */
//    public MyQueue() {
//        stack1 = new Stack<>();
//        stack2 = new Stack<>();
//    }
//
//    /** Push element x to the back of queue. */
//    public void push(int x) {
//        stack1.push(x);
//    }
//
//    /** Removes the element from in front of queue and returns that element. */
//    public int pop() {
//        while (!stack1.empty()) {
//            stack2.push(stack1.pop());
//        }
//        int pop = stack2.pop();
//        while (!stack2.empty()) {
//            stack1.push(stack2.pop());
//        }
//        return pop;
//    }
//
//    /** Get the front element. */
//    public int peek() {
//        while (!stack1.empty()) {
//            stack2.push(stack1.pop());
//        }
//        int peek = stack2.peek();
//        while (!stack2.empty()) {
//            stack1.push(stack2.pop());
//        }
//        return peek;
//    }
//
//    /** Returns whether the queue is empty. */
//    public boolean empty() {
//        return stack1.empty();
//    }
}
