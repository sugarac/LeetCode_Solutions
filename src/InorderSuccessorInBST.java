public class InorderSuccessorInBST {
    /**
     * Solution1: O(h); O(1)
     * Set root node as current node and then Search BST.
     * While current node is not null, if the value of current node > the value of target node,
     * update result to current node and move current node to left, otherwise right.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > p.val) {
                res = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return res;
    }
}
