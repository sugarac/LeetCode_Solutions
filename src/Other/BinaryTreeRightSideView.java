package Other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    /**
     * Solution1: BFS O(n); O(w)
     * Use reverse Level Order Traversal to get rightmost node of each level.
     * During BFS, add rightmost node of each level to result and then add each node’s right and left child to queue.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    res.add(cur.val);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }
        return res;
    }

    /**
     * Solution2: DFS O(n); O(h)
     * During DFS, if current depth = result size, means that it's at the correct level, add current node's value to result.
     * Recurse down next level with right node first and depth + 1. Then left node.
     */
    public List<Integer> rightSideViewB(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode cur, int depth) {
        if (cur == null) {
            return;
        }

        if (depth == res.size()) {
            res.add(cur.val);
        }
        dfs(res, cur.right, depth + 1);
        dfs(res, cur.left, depth + 1);
    }
}
