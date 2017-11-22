package Other;

public class CountCompleteTreeNodes {
    /**
     * Solution1: Recursive O((logn)^2); O(logn)
     * Calculate the height of left and right subtree of current TreeNode respectively.
     * If their heights are same which means left subtree is full, move current TreeNode to its right child.
     * Otherwise which means left subtree is not full, move to its left child.
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            return (1 << rightHeight) + countNodes(root.left);
        }
    }

    private int getHeight(TreeNode cur) {
        int height = 0;
        while (cur != null) {
            height++;
            cur = cur.left;
        }
        return height;
    }

    /**
     * Solution2: Recursive O((logn)^2); O((logn)^2)
     * https://discuss.leetcode.com/topic/15533/concise-java-solutions-o-log-n-2
     */
//    public int countNodes(TreeNode root) {
//        int h = height(root);
//        return h < 0 ? 0 :
//                       height(root.right) == h - 1 ? (1 << h) + countNodes(root.right) :
//                                                     (1 << h - 1) + countNodes(root.left);
//    }
//
//    private int height(TreeNode cur) {
//        return cur == null ? -1 : 1 + height(cur.left);
//    }
}
