package Other;

public class LinkedListCycle {
    /**
     * follow up:
     * 1.(Youtube) Given an array of integers where each element points to the index of the next element
     * how would you detect if there is a cycle in this array?
     */

    /**
     * Slow and fast pointers O(n); O(1)
     * Use two pointers, slow and fast.
     * Move slow pointer step by step, move fast pointer two steps at a time.
     * If the Linked List has a cycle, slow and fast will meet at some point.
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
