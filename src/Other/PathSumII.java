package Other;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    /**
     * Solution1: DFS O(n); O(h)
     * Subtract the value of current node from sum until it reaches a leaf node.
     * If current sum equals 0, add current path to result.
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), root, sum);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(path));
        }

        dfs(res, path, root.left, sum);
        dfs(res, path, root.right, sum);
        path.remove(path.size() - 1);
    }
}
