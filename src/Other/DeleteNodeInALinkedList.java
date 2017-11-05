package Other;

public class DeleteNodeInALinkedList {
    /**
     * Solution1: O(1); O(1)
     * Change the value of node to the value of node’s next.
     * Let the next of node point to the next of node’s next.
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
