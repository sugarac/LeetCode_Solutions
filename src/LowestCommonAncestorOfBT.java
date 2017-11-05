public class LowestCommonAncestorOfBT {
    /**
     * Medium (F,L,A,A,M)
     * follow up:
     * 1.http://www.1point3acres.com/bbs/thread-167887-1-1.html
     */

    /**
     * Recursive O(n);O(h)
     * Recurrence relation:
     * Search for p and q in left and right subtrees.
     * If both are found, it means the two nodes are in different subtrees, root should be their LCA.
     * If one of them is null, it means no possible LCA found for p or q.
     * Then the one that is not null should be their LCA.
     * Base case:
     * If root is null, return null; if root is p or q, return p or q, respectively.
     */

    /**
     * 从上向下搜索, 遇到p或q或null, return之
     * 回溯过程中,
     * (1).左return != null且右return != null (即左p右q或左q右p), 说明current root是LCA, return之;
     * (2).左右谁不为null就向上return谁 (即p或q, 或null).
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
