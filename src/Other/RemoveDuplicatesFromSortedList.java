package Other;

public class RemoveDuplicatesFromSortedList {
    /**
     * O(n); O(1)
     * Use a current pointer which starts from head node.
     * If cur.val == cur.next.val, let cur.next point to the next of cur.next.next until meet node with different value.
     * Then move cur to cur.next.
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode deleteDuplicatesC(ListNode head) {
        if (head == null) { //只用一个while loop的话，必须要判断head是否为空，因为while条件是cur.next != null
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * ，
     * 根据II的解法修改，有冗余，不推荐
     */
    public ListNode deleteDuplicatesB(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (pre.next == cur) {
                pre = cur;
            } else {
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
