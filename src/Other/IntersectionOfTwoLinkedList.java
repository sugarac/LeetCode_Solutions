package Other;

public class IntersectionOfTwoLinkedList {
    /**
     * Math O(logn); O(1)
     * Use two iterations to do that.
     * In the first iteration, we will reset the pointer of one LinkedList to the head of another LinkedList after it reaches the tail node.
     * In the second iteration, we will move two pointers until they point to the same node. Our operations in first iteration will help us counteract the difference.
     * So, if two LinkedList intersects, the meeting point in second iteration must be the intersection point. a + c + b + c = b + c + a + c
     * If the two linked lists have no intersection at all, then the meeting pointer in second iteration must be the tail node of both lists, which is null.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public ListNode getIntersectionNodeB(ListNode headA, ListNode headB) { //第一次写的，又臭又长
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }

        curA = headA;
        curB = headB;
        if (lenA > lenB) {
            while (lenA - lenB > 0) {
                curA = curA.next;
                lenA--; //important!
            }
        } else {
            while (lenB - lenA > 0) {
                curB = curB.next;
                lenB--; //important!
            }
        }

        while (curA != null) {
            if (curA == curB) {
                return curA;
            }

            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
