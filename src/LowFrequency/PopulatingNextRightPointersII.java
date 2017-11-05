package LowFrequency;

public class PopulatingNextRightPointersII {
    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
    /**
     * Medium (F,G,A,M,B)
     * follow up:
     * 1.唯一不一样的是，每一个level的最后一个node的next要指向下一层的第一个node。
     */

    /**
     * Dummy node O(n);O(1)
     * Create a pointer pre initialized as root, means the pointer of previous level.
     * Create a dummy head before the each next level's leftmost node.
     * While pre is not null:
     * | Initialize a pointer of current level cur from dummy.
     * | While pre is not null:
     * |   If pre.left is not null:
     * |     Set cur.next to pre.left, move cur.
     * |   If pre.right is not null:
     * |     Set cur.next to pre.right, move cur.
     * |   Move pre to pre.next since all possibilities of pre node are done.
     * | Move pre to dummy.next because current level is fully connected.
     * | dummy.next is the leftmost node of next level.
     */
    public void connect(TreeLinkNode root) {
        TreeLinkNode pre = root;
        TreeLinkNode dummy = new TreeLinkNode(0);
        while (pre != null) {
            TreeLinkNode cur = dummy;
            while (pre != null) {
                if (pre.left != null) {
                    cur.next = pre.left;
                    cur = cur.next;
                }
                if (pre.right != null) {
                    cur.next = pre.right;
                    cur = cur.next;
                }
                pre = pre.next;
            }
            pre = dummy.next; // IMPORTANT! dummy.next is updated when cur.next is first set.
            dummy.next = null;
        }
    }
}
