package Other;

public class RemoveDuplicatesFromSortedListII {
    /**
     * Dummy Node O(n); O(1)
     * Create a dummy node, the next of which is head node.
     * Use a previous pointer which starts from dummy node to track the last node before duplicate nodes.
     * Use a current pointer which starts from head node to track the last node of duplicate nodes.
     * During the traverse, if the next of pre is cur, which means no duplicates, move pre to cur,
     * otherwise which means duplicates exist, let the next of pre point to the next of cur.
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (pre.next == cur) {
                pre = cur; //no duplicates
            } else {
                pre.next = cur.next; //duplicates
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
