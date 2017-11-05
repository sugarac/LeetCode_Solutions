package Other;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        for (int i = m; i < n; i++) {
            // ListNode next = cur.next;
            // cur.next = pre;
            // pre = cur;
            // cur = next;
            ListNode temp = cur.next.next;
            cur.next.next = pre.next;
            pre.next = cur.next;
            cur.next = temp;
        }
        return dummy.next;
    }
}
