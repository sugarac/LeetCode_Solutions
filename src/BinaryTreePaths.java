import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths {
    /**
     * Easy (F,G,AP)
     * follow up:
     * 1.打印path不用回传 + 时间复杂度(要考虑打印时间) http://www.1point3acres.com/bbs/thread-210730-1-1.html
     * System.out.println(sb.toString());O(nlogn)
     * O(n), O(nlogn), O(n^2)都是可能的。要看tree的configuration。balanced tree应该是average case而不是worst case。
     * 2.要求打印出path, follow up: 1.如果所有的node在一条线上，时间复杂度。2.full binary tree 时间复杂度。3.优化时间复杂度
     * http://www.1point3acres.com/bbs/thread-214582-1-1.html
     * O(n);O(nlogn);StringBuilder
     */

    /**
     * DFS with helper function O(n);O(h)
     * The path from root to leaf can be obtained by:
     * At each node, add its left child's val to the path, traverse the left subtree.
     * Then add its right child's val to the path, traverse the right subtree.
     * The base case is when we reach a leaf, we add the path to result.
     */
    public List<String> binaryTreePathsC(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root, sb, res);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder sb, List<String> res) {
        if (root == null) {
            return;
        }

        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            // System.out.println(sb.toString());
        } else {
            sb.append("->");
            dfs(root.left, sb, res);
            dfs(root.right, sb, res);
        }
        sb.setLength(len);
    }

    /**
     * DFS without helper function O(n^2);O(h)
     * Recurrence relation:
     * The paths consist of root + all subtrees paths.
     * Base case:
     * If root == null, the result list would be empty.
     * If root is a leaf node, then its value would be in list.
     */
    public List<String> binaryTreePathsB(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) { //exit recursion
            return paths;
        }

        if (root.left == null && root.right == null) {
            paths.add(root.val + "");
            return paths;
        }

        for (String path : binaryTreePathsB(root.left)) { //divide & merge
            paths.add(root.val + "->" + path);
        }
        for (String path : binaryTreePathsB(root.right)) { //divide & merge
            paths.add(root.val + "->" + path);
        }
        return paths;
    }

    /**
     * BFS
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> qNode = new LinkedList<>();
        Queue<String> qStr = new LinkedList<>();
        qNode.add(root);
        qStr.add("");
        while (!qNode.isEmpty()) {
            TreeNode curNode = qNode.remove();
            String curStr = qStr.remove();

            if (curNode.left == null && curNode.right == null) {
                res.add(curStr + curNode.val);
            }
            if (curNode.left != null) {
                qNode.add(curNode.left);
                qStr.add(curStr + curNode.val + "->");
            }
            if (curNode.right != null) {
                qNode.add(curNode.right);
                qStr.add(curStr + curNode.val + "->");
            }
        }
        return res;
    }

}
