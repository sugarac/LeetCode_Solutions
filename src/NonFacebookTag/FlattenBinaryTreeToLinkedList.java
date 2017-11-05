package NonFacebookTag;

import Other.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    /**
     * Medium (F,M)
     * 1.返回的是Doubled Linked List，并且顺序是树的Inorder Traversal。
     * http://www.1point3acres.com/bbs/thread-288511-1-1.html
     * Solution: http://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
     * (Circular)https://www.youtube.com/watch?v=Dte6EF1nHNo
     */

    /**
     * Iterative O(n); O(1)
     * For current node:
     *   If left subtree is not null:
     *     Find the right most node of left subtree.
     *     Connect it with cur.right.
     *     Set cur.right to cur.left.
     *   Move cur to cur.right, which was cur.left.
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode rightMost = cur.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                rightMost.right = cur.right;
                cur.right = cur.left; //题目要求，左空右直
                cur.left = null; //题目要求，左空右直
            }
            cur = cur.right;
        }
    }
}
