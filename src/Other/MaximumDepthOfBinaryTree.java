package Other;

public class MaximumDepthOfBinaryTree {
    /**
     * Recursive O(h); O(1)
     * If the current node does not exist, simply return 0. Otherwise,
     * return the 1+the longer distance of its left and right subtrees.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
