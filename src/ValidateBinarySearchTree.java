import java.util.Stack;

public class ValidateBinarySearchTree {
    /**
     * Medium (F,A,M,B)
     * <p>
     * follow up:
     * 1.唯一不同的是妹子/大姐的定义 树可以有重复的值， root大于或者等于左子树，小于或者等于右子树
     * change >= to >
     * 2.(A) Validate Full Binary Tree, which is different from Complete Binary Tree.
     */

    /**
     * Recursive, inorder traversal
     * O(n);O(h)
     * 1.Check current root, if it's null, return true.
     * 2.Check left subtree, if it's not a BST, return false.
     * 3.Use a global variable to remember the largest node in the left subtree.
     * Compare with current node, if the value of this node is greater than or equal to the value of current node, return false.
     * 4.update this global variable.
     * 5.Check right subtree, if its not a BST, return false.
     * 6.Return true if all tests passed.
     */
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) { //空树定义为true，记住
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
//        return isValidBST(root.right);    //The following code is more readable.
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }

    /**
     * Iterative, inorder traversal
     * The template of Binary Tree inorder traversal is very useful here.
     * Solution1: Iterative O(n); O(h) (Inorder Template: 94, 98, 230)
     * Run iterative inorder traversal in given tree.
     * If there is a node that violates the definition of BST, return false.
     */
    public boolean isValidBSTB(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode pre = null;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (pre != null && pre.val >= cur.val) {
                return false;
            }
            pre = cur;
            cur = cur.right;
        }
        return true;
    }

//    public boolean isValidBSTC(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        TreeNode pre = null;
//        TreeNode cur = root;
//        Stack<TreeNode> stack = new Stack<>();
//        while (cur != null || !stack.empty()) {
//            while (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            if (pre != null && pre.val >= cur.val) {
//                return false;
//            }
//            pre = cur;
//            cur = cur.right;
//        }
//        return true;
//    }

    public boolean isValidBSTD(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode p = stack.pop();
                if (pre != null && p.val <= pre.val) {
                    return false;
                }
                pre = p;
                cur = p.right;
            }
        }
        return true;
    }
}
