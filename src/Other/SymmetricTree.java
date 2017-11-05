package Other;

import java.util.Stack;

public class SymmetricTree {
    /**
     * Easy (Many)
     * follow up:
     * 1.(G)如果有left, mid, right三个child怎么办。
     */

    /**
     * Recursive O(n); O(h)
     * Run DFS on both subtrees, n1 and n2.
     * If at least one node is null, return true if they are both null, otherwise false.
     * Then check both current nodes values.
     * Check n1.left and n2.right. Check n1.right and n2.left.
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) {
            return n1 == n2;
        }
        if (n1.val != n2.val) {
            return false;
        }

        return dfs(n1.left, n2.right) && dfs(n1.right, n2.left);
    }

    /**
     *
     */
    public boolean isSymmetricB(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if (n1 == null && n2 == null) {
                continue;
            }
            if (n1 == null || n2 == null || n1.val != n2.val) {
                return false;
            }

            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }
}
