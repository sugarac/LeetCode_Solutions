package Other;

public class MinimumDepthofBinaryTree {
    /**
     * Solution1: Recursive O(n); O(h)
     * If one of left and right subtrees is null, return the min depth of the other subtree plus 1.
     * Otherwise, return the smaller depth of min depth of left and right subtrees plus 1.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
