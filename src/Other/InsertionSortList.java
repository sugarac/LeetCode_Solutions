package Other;

public class InsertionSortList {
    /**
     * Solution1: dummy node O(n^2); O(1)  change pre-> pre.next to pre->cur->pre.next
     * Create a dummy node which points to the head of new sorted list, a pointer “pre” which starts from dummy
     * and a pointer “cur” which starts from head.
     * During while loop, find the place in the new list to insert the current head of old list
     * And then insert it to the new list and move cur to its next, check if pre’s value is larger than cur’s value.
     * If larger, reset pre to dummy. Otherwise find place from pre to save time.
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0); //new starter of the sorted list
        ListNode pre = dummy; //insert node between pre and pre.next
        ListNode cur = head; //the node will be inserted

        while (cur != null) {
            while (pre.next != null && pre.next.val < cur.val) {//find the right place to insert
                pre = pre.next;
            }

            ListNode next = cur.next;//insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            cur = next;

            //optimization, 如果原链表的头结点大于pre，说明pre还应该往后移，此时不需要令pre=dummy
            //特别是原链表已经有序时，O(n)即可完成排序
            if (pre.val >= cur.val) {
                pre = dummy;
            }
        }

        return dummy.next;
    }
}
