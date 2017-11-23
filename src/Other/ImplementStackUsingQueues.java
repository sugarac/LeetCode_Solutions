package Other;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    /**
     * Solution1: O(n) push O(1) others
     * For push(), add x to queue and then poll all the elements before x, add them to queue in order.
     */
    Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
