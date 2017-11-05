package Other;

public class PathSum {
    /**
     * Solution1: DFS O(n); O(h)
     * Subtract the value of current node from sum until it reaches a leaf node and sum equals 0.
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
