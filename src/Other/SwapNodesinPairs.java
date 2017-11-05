package Other;

public class SwapNodesinPairs {
    /**
     * Iterative O(n); O(1)
     * Create a dummy node and a current node start from dummy.
     * While cur, cur.next, cur.next.next are all not null
     * The current node’s next is the result of swapping cur.next and cur.next.next.
     * Then the current node moves to cur.next.next.
     * Return dummy’s next as head.
     */
    public ListNode swapPairsB(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null && cur.next.next != null) {
            cur.next = swap(cur.next, cur.next.next);
            cur = cur.next.next;
        }
        return dummy.next;
    }

    private ListNode swap(ListNode n1, ListNode n2) {
        n1.next = n2.next;
        n2.next = n1;
        return n2;
    }

    /**
     * Recursive O(n); O(n)
     * Recurrence Relation:
     * Create a node “second” to store head’s next.
     * Then let head’s next point to the result of the next node pair.
     * Then let second’s next point to head. Return second.
     * Base cases:
     * If head or head’s next is null, return head.
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode second = head.next;
        head.next = swapPairs(head.next.next);
        second.next = head;
        return second;
    }
}
