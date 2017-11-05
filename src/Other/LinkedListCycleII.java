package Other;

public class LinkedListCycleII {
    /**
     * Slow and fast pointers O(n); O(1)
     * Use two pointers, slow and fast.
     * Move slow pointer step by step, move fast pointer two steps at a time.
     * If the Linked List has a cycle, slow and fast will meet at some point.
     * Reset slow to head after cycle is detected.
     * Then move slow and fast step by step respectively until they meet.
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
