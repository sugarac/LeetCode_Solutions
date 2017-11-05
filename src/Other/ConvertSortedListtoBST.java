package Other;

public class ConvertSortedListtoBST {
    /**
     * Solution1: Recursive O(nlogn); O(h)
     * Use slow and fast pointers to find middle ListNode of given list.
     * Create a node with the value of middle ListNode.
     * Then generate the left and right children recursively.
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) { //tricky
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) { //important
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = toBST(head, slow);
        node.right = toBST(slow.next, tail);
        return node;
    }
}
