package Other;

public class ConstructBTFromPreInOrder {
    /**
     * DFS O(n); O(h)
     * Take the first element in Preorder array as the root.
     * Find the index of the root in the inorder array.
     * Then calculate the index range of left subtree and right subtree and do recursion.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[ps]);
        int rootIndex = is;
        for (; rootIndex <= ie; rootIndex++) {
            if (inorder[rootIndex] == root.val) {
                break;
            }
        }

        root.left = buildTree(preorder, inorder, ps + 1, ps + rootIndex - is, is, rootIndex - 1);
        root.right = buildTree(preorder, inorder, ps + rootIndex - is + 1, pe, rootIndex + 1, ie);
        return root;
    }
}
