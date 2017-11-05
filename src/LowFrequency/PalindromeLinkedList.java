package LowFrequency;

public class PalindromeLinkedList {
    /**
     * Easy (F,A)
     */

    /**
     * 同向Two Pointers O(n);O(1)
     * Find the middle node, reverse the right half list, then check each node.
     * Use two pointers, one slow pointer s, one fast pointer f.
     * Move s to the head of the right half list.
     * If there are odd number of nodes, move s one step further.
     * Reverse the right half of the list starting from s.
     * Then compare each node's value while s is not null.
     * If diff, return false. Else continue.
     * After all nodes checked, return true.
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        slow = reverseList(slow);

        ListNode cur = head;
        while (slow != null) {
            if (cur.val != slow.val) {
                return false;
            }
            cur = cur.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) { //cur.next can be null when cur is the last node
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
