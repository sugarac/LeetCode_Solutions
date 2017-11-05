package Other;

public class ConstructBTFromInPostOrder {
    /**
     * Solution1: DFS O(n); O(h)
     * Take the last element in Postorder array as the root.
     * Find the index of the root in the inorder array.
     * Then locate the range for left sub-tree and right sub-tree and do recursion.
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }

        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
        if (ps > pe) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pe]);
        int rootIndex = is;
        for (; rootIndex <= ie; rootIndex++) {
            if (inorder[rootIndex] == root.val) {
                break;
            }
        }

        root.left = buildTree(inorder, postorder, is, rootIndex - 1, ps, ps + rootIndex - 1 - is);
        root.right = buildTree(inorder, postorder, rootIndex + 1, ie, pe - ie + rootIndex, pe - 1);
        return root;
    }
}
