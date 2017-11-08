package Other;

import java.util.ArrayList;
import java.util.List;

public class SumRoottoLeafNumbers {
    /**
     * Solution1: DFS O(n); O(h)
     * During DFS, calculate the path sum from root to current node.
     * Then calculate the path sum of left and right subtree recursively.
     * If current node is leaf node, return current path sum.
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }

    /**
     * Solution2: DFS O(n); O(w + h) 最初的想法，用的是常规DFS模板
     */
    public int sumNumbersB(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        dfs(nums, 0, root);

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    private void dfs(List<Integer> nums, int num, TreeNode root) {
        if (root == null) {
            return;
        }

        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            nums.add(num);
        }

        dfs(nums, num, root.left);
        dfs(nums, num, root.right);
    }

//    public int sumNumbers(TreeNode root) { //有问题，sum一直输出0，不知道具体原因。
//        int sum = 0;
//        dfs(sum, 0, root);
//        return sum;
//    }
//
//    private void dfs(int sum, int pathSum, TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        pathSum = pathSum * 10 + root.val;
//        if (root.left == null && root.right == null) {
//            sum += pathSum;
//            System.out.println(sum);
//        }
//
//        dfs(sum, pathSum, root.left);
//        dfs(sum, pathSum, root.right);
//    }
}
