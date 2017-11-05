package Other;

public class RotateList {
    /**
     * Two pointers O(n);O(1)
     * Move fast pointer to the end of the list to get length
     * Move slow pointer to len - n % len to get the break point
     * Connect fast pointer with head and new head is next of slow pointer.
     * Set slow.next to null to unlink the list.
     */
    public static ListNode rotateRightB(ListNode head, int k) { //不用dummy node，len和i要改成1
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        int len = 1;
        for (; fast.next != null; len++) {
            fast = fast.next;
        }

        for (int i = 1; i < len - k % len; i++) {
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        int len = 0;
        for (; fast.next != null; len++) {
            fast = fast.next;
        }

        for (int i = 0; i < len - k % len; i++) {
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }


}
