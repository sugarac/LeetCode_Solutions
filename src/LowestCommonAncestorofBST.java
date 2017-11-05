public class LowestCommonAncestorofBST {
    /**
     * Easy (F,A,M,T)
     * follow up:
     * 1.需要考虑查找的节点不在树里的情况;如果要检查在不在树里，是需要找到root之后分别在左右子树里再找一遍这两个节点存不存在吗？有更好的方法吗?我是这么做的，面试官觉得OK。
     * 考察的问题：->查找某个节点是否在二叉树里: boolean find(TreeNode root, TreeNode target)
     */

    /**
     * Iterative
     * O(h);O(1)
     * we can use (root.val - (long)p.val) * (root.val - (long)q.val) to avoid overflow, which is not necessary here.
     * 1.In BST, the LCA's value can only be [p, q].
     * And LCA is the first from top to bottom that lies in range.
     * 2.If root's value is more than both p and q's values, move to left subtree.
     * 3.If root's value is less than both p and q's values, move to right subtree.
     * 4.Otherwise, current node is LCA.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return root;
        }

        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = root.val - p.val > 0 ? root.left : root.right;
        }

//        if (!find(root, p)) {
//            System.out.println("p is not in the Binary Tree");
//        }
//        if (!find(root, q)) {
//            System.out.println("q is not in the Binary Tree");
//        }

        return root;
    }

    /**
     * Recursive, DFS O(h);O(h)
     * 1.In BST, the LCA's value can only be [p, q].
     * And LCA is the first from top to bottom that lies in range.
     * 2.If root's value is more than both p and q's values, move to left subtree.
     * 3.If root's value is less than both p and q's values, move to right subtree.
     * 4.Otherwise, current node is LCA.
     */
    public TreeNode lowestCommonAncestorB(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            return root;
        } else if (root.val - p.val > 0) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    private boolean find(TreeNode root, TreeNode target) {
        if (root == null || target == null) {
            return false;
        }

        if (root == target) {
            return true;
        }
        if (find(root.left, target) || find(root.right, target)) {
            return true;
        }
        return false;
    }

}
