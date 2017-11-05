public class MergeTwoSortedLists {
    /**
     * Easy (F,L,M,A,A)
     */

    /**
     * Iterative O(n);O(1)
     */
    public ListNode mergeTwoListsB(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if ((l1 != null && l2 != null && l1.val < l2.val) || (l1 != null && l2 == null)) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
/*
    public ListNode mergeTwoListsB(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
*/

    /**
     * Recursive O(n);O(n)
     * Recurrence Relation:
     * Pick the node with smaller value as current head h.
     * Then connect h with the merged result of h.next and the other node, return h.
     * Base case:
     * 1. l1 is null, return l2.
     * 2. l2 is null, return l1.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
