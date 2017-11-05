package Other;

public class BalancedBinaryTree {
    /**
     * Solution1: Recursive Top-down, O(nlogn); O(h)
     * Calculate the height of left and right subtrees, and then check if them differ by more than 1.
     * If yes, return false, otherwise check left and right children.
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left - right) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
