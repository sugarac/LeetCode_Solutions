package Other;

public class AddTwoNumbers {
    /**
     * Math.
     * Check the two input list first. If one is null, return the other.
     * Now the two heads are not null.
     * Create a dummy node and a current pointer start from dummy.
     * Create an integer to store the carry.
     * While l1 is not null or l2 is not null or carry is not zero:
     * | If l1 is not null:
     * |   Add its value to carry. Move l1 to next.
     * | If l2 is not null:
     * |   Add its value to carry. Move l2 to next.
     * | Create a new node with value carry % 10.
     * | Append new node after current. Move current to next.
     * | Update carry.
     * Return dummy.next.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (n1 != null || n2 != null || carry != 0) {
            if (n1 != null) {
                carry += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                carry += n2.val;
                n2 = n2.next;
            }

            cur.next = new ListNode(carry % 10);
            cur = cur.next;
            carry /= 10;
        }
        return dummy.next;
    }
}
