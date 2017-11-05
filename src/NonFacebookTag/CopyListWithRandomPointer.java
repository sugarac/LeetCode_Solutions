package NonFacebookTag;

public class CopyListWithRandomPointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
    /**
     * Medium (F,G,U,B)
     * follow up:
     * 1.不占用额外的空间，但时间复杂度不能变成O(n^2)
     */

    /**
     * One-pass with dummy node O(n);O(1)
     * Create a dummy node and a current pointer of copy list start from dummy.
     * Use another pointer to traverse the input linked list.
     * Each time, copy current node and the random of current node.
     * Then move current pointer of copy list and input list to next respectively.
     */
    public RandomListNode copyRandomListC(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode curCopy = dummy;
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            copy.random = cur.random == null ? null : new RandomListNode(cur.random.label);
            curCopy.next = copy;
            curCopy = curCopy.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * Three-pass O(n);O(1)
     * 1.make copy each node,and link them together side-by-side in a single list
     * 2.copy random pointers for the copy nodes
     * 3.restore the original list, and extract the copy list
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode n = head;
        while (n != null) {    //should be n != null, otherwise, if n.next == null, the node n will not be copied.
            RandomListNode next = n.next;
            n.next = new RandomListNode(n.label);
            n.next.next = next;
            n = next;
        }

        n = head;
        while (n != null) {
            if (n.next != null) {
                n.next.random = n.random.next;
            }
            n = n.next.next;
        }

        n = head;
        RandomListNode copyHead = head.next;
        RandomListNode copy = copyHead;
        while (copy.next != null) {
            n.next = n.next.next;
            n = n.next;

            copy.next = copy.next.next;
            copy = copy.next;
        }
        n.next = null;

        return copyHead;
    }
}
