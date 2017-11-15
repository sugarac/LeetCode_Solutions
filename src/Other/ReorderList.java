package Other;

public class ReorderList {
    /**
     * Solution1: O(n); O(1)
     * Find the middle node of the list, reverse the list after middle node, start reorder one by one.
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = head;
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            mid = mid.next;
            tail = tail.next.next;
        }

        ListNode cur = mid.next;
        mid.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = mid.next;
            mid.next = cur;
            cur = next;
        }

        ListNode left = head;
        ListNode right = mid.next;
        while (right != null) { // right list is shorter than left list.
            mid.next = right.next;
            right.next = left.next;
            left.next = right;

            left = right.next;
            right = mid.next;
        }
    }
}
