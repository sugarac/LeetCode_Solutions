package Other;

public class PartitionList {
    /**
     * Dummy Node O(n); O(1)
     * Maintain two lists, the first one stores all nodes with val less than x , and the second list stores all the rest nodes.
     * Then connect these two lists. Remember to set the tail of second queue a null next, or u will get TLE.
     */

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = head;
            } else {
                cur2.next = head;
                cur2 = head;
            }
            head = head.next;
        }
        cur2.next = null; //important! avoid cycle in linked list. otherwise u will get TLE.
        cur1.next = dummy2.next;
        return dummy1.next;
    }
}
