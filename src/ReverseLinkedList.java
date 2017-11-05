import java.util.Stack;

public class ReverseLinkedList {
    /**
     * Easy (Many)
     * follow up:
     * 1.http://www.1point3acres.com/bbs/thread-214933-1-1.html
     * https://discuss.leetcode.com/topic/248/
     * print-out-an-immutable-singly-linked-list-in-reverse-in-linear-time-o-n-and-less-than-linear-space-space-o-n?page=1
     * 2.how to do it without change pointer
     */

    /**
     * Iterative & modify the linked list O(n);O(1)
     * Get one node each time and make it the new head of the reversed list.
     * Create a head of the linked list as null.
     * Use the original head as a pointer to iterate the list.
     * While the original head:
     * | First store the next head.
     * | Then set head.next to newHead.
     * | Move newHead to head.
     * | Move head to its stored next.
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next; //cur.next can be null when cur is the last node
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void reverseListB(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        while (newHead != null) {
//            if (newHead.next == null) {
//                System.out.print(newHead.val);
//                break;
//            }
//            System.out.print(newHead.val + "->");
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    /**
     * Iterative with stack O(n):O(n)
     */
/*    public ListNode reverseListC(ListNode head) { //TLE, don't know why
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!stack.empty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        return dummy.next;
    }*/
    public void reverseListD(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while (!stack.empty()) {
            System.out.print(stack.pop().val + " ");
        }
    }

    /**
     * Recursive O(n);O(n)
     * Divide the list into 2 parts - head and the rest starts from head.next.
     * Reverse the rest of the linked list.
     * Append head to the tail of reversed linked list, which is head's next.
     * Return newHead of the reversed linked list.
     */
    public ListNode reverseListE(ListNode head) {
        if (head == null || head.next == null) { // Empty list or just 1 node.
            return head;
        }

        ListNode newHead = reverseList(head.next); // Similar to post-order.
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public void reverseListF(ListNode head) {
        if (head == null) {
            return;
        }
        reverseListF(head.next);
        System.out.print(head.val + " ");
    }

    /**
     * how to do it without change pointer
     */

    /**
     * Recursive with two pointers
     */
    ListNode left = null;
    boolean meet = false;

    public ListNode reverseListG(ListNode head) {
        if (head == null || head.next == null) return head;
        left = head;
        meet = false;
        helper(head);
        return head;
    }

    public ListNode helper(ListNode head) {
        if (head.next == null) return head;

        ListNode right = helper(head.next);
        if (!meet) {
            int tmp = left.val;
            left.val = right.val;
            right.val = tmp;
            if (left == right || left.next == right) meet = true;
            left = left.next;
        }
        return head;
    }
}
