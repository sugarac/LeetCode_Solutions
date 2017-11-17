package Other;

public class BinaryTreeUpsideDown {
    /**
     * https://discuss.leetcode.com/topic/40924/java-recursive-o-logn-space-and-iterative-solutions-o-1-space-with-explanation-and-figure
     * Solution1: Iterative O(n); O(1)
     * Create a current pointer “cur” which starts from root node.
     * pre: parent node, cur: current node, sibling: sibling node, next: left child
     * Set its left child to its sibling node, set its right child to its parent node.
     * Then move “cur” to its original left child.
     */
    public TreeNode upsideDownBinaryTreeB(TreeNode root) {
        TreeNode pre = null;
        TreeNode cur = root;
        TreeNode sibling = null;
        while (cur != null) {
            TreeNode next = cur.left;
            cur.left = sibling;
            sibling = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     *
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);//root.left很巧妙
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
