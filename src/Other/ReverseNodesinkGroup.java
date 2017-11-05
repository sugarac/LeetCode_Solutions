package Other;

public class ReverseNodesinkGroup {
    /**
     * Iterative O(n); O(1)
     * Divide linked list into two parts:
     * The first K nodes as a group, L1, might not exist. The rest of the linked list, L2.
     * So first we move a pointer to the head of L2.
     * If we reach the end before K step, no more reverse, break and return.
     * If we find the head of L2, restHead, use it as a stop point for reverse.
     * Then we reverse the current group.
     */
    public ListNode reverseKGroupB(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy; // Current group dummy. Or the tail of previous group.
        ListNode cur = head; // Current group head.

        while (cur != null) {
            ListNode rest = cur;
            int group = k;
            while (rest != null && group > 0) { // Find nextHead.
                group--;
                rest = rest.next;
            }
            if (group > 0) { // Reach list end.
                break;
            }
            // Similar to reverse linked list.
            while (cur.next != rest) { // Ends at the head of remaining list.
                ListNode temp = cur.next.next;
                cur.next.next = pre.next;
                pre.next = cur.next;
                cur.next = temp;
            }
            pre = cur; // Move current dummy to the end of current group.
            cur = cur.next; // Move current head to the next group.
        }
        return dummy.next;
    }

/*    public ListNode reverseKGroup(ListNode head, int k) { //不太好
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode tail = dummy;
        while (true) {
            int count = k;
            while (count > 0 && tail != null) {
                count--;
                tail = tail.next;
            }
            if (tail == null) {
                break;
            }

            ListNode tempHead = cur.next;
            while (cur.next != tail) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = tail.next;
                tail.next = temp;
            }
            cur = tempHead;
            tail = tempHead;
        }
        return dummy.next;
    }*/
}
