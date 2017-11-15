package Other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }

    /**
     * Solution2: Iterative O(n); O(1)
     * First, push root node into stack.
     * During while loop, pop the element on the top of the stack and add its value to result list.
     * Then push its right and left children into stack in order if not null. Repeat until stack is empty.
     */
    public List<Integer> preorderTraversalB(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }
}
