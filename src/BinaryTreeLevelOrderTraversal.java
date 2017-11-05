import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    /**
     * Medium (F,L,A,A,M,B)
     * follow up:
     * 1.打印出每层最大的两个数字，如果不到2个，就打印null.
     * see levelOrderC
     * 2.print 出来 BST 每一层，一层一行，逗号空格分开，lc102简化版
     * System.out.println(curLevel); or
     * System.out.print(head.val + " "); //below head
     * System.out.println(); //below for-loop
     * 3.LC 314 Binary Tree Vertical Order Traversal (Medium) ( 收费题)
     */

    /**
     * BFS O(n);O(w)
     * 1.Use Queue to store nodes of each level.
     * 2.Traverse one level at each iteration instead of regular BFS, since result needs to be stored in List-List.
     * 3.By getting the size of the queue, we know how many nodes in current level.
     * 4.If left or right child of current node is not null, add it to the queue.
     * 5.Add value of nodes of each level into the result.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 1.add start node into queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 2.while queue is not empty
        while (!queue.isEmpty()) {
            // 3.level x -> x + 1
            List<Integer> curLevel = new ArrayList<>(); //can be replaced by deep copy, but will lead to low efficiency
            int size = queue.size();
            for (int i = 0; i < size; i++) { //level x
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left); //level x + 1
                }
                if (node.right != null) {
                    queue.add(node.right); //level x + 1
                }
            }
            res.add(curLevel); // no deep copy
        }
        return res;
    }

    /**
     * DFS
     * O(n);O(h)
     */
    public List<List<Integer>> levelOrderB(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);

        dfs(res, root.left, level + 1);
        dfs(res, root.right, level + 1);
    }

    /**
     * follow up:
     * 1.打印出每层最大的两个数字，如果不到2个，就打印null.
     * <p>
     * BFS
     * O(n);O(1)
     */
    public List<List<Integer>> levelOrderC(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 1.add start node into queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 2.while queue is not empty
        while (!queue.isEmpty()) {
            // 3.level x -> x + 1
            // List<Integer> curLevel = new ArrayList<>(); //can be replaced by deep copy, but will lead to low efficiency
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            int secondMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) { //level x
                TreeNode head = queue.poll();
                // curLevel.add(head.val);
                if (head.val > max) {
                    secondMax = max;
                    max = head.val;
                } else if (head.val > secondMax) {
                    secondMax = head.val;
                }
                // System.out.print(head.val + " ");
                if (head.left != null) {
                    queue.add(head.left); //level x + 1
                }
                if (head.right != null) {
                    queue.add(head.right); //level x + 1
                }
            }
            System.out.println(max == Integer.MIN_VALUE ? "NULL" : max + " " + (secondMax == Integer.MIN_VALUE ? "NULL" : secondMax));
            // res.add(curLevel); // no deep copy
            // System.out.println(curLevel);
        }
        return res;
    }

}
