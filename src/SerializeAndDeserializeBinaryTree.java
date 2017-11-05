import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    /**
     * Hard (F,L,G,A,U,M,Y,B)
     * follow up:
     * 1.與原題不同的地方在於：規定要把 tree 轉成 "linked list" ，再把 "linked list" 轉成 tree
     * BFS + Pre Order ＋ 记录null 的位置应该就可以做了 和297没区别。。把StringBuffer 改成 List 就好了
     * http://www.1point3acres.com/bbs/thread-215063-1-1.html
     * 2.有点像LC 297，但是是BST，而且给出了一个preorder的list，没有#标识符表示空节点
     * http://www.1point3acres.com/bbs/thread-210036-1-1.html
     */

    /**
     * BFS O(n);O(h) O(n);O(n)
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head == null) {
                res.append("#,");
                continue;
            }
            res.append(head.val + ",");
            queue.offer(head.left);
            queue.offer(head.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if (!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.offer(left);
            }
            if (!values[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

    /**
     * Recursive
     * use preorder traversal with root and a StringBuilder object.
     * Append current node's val and a delimiter.
     * Then recurse down to left and right subtrees.
     * Base case:
     * If node is null, append a null node and a delimiter.
     * => 1,2,#,#,3,4,#,#,5,#,#,
     */
    // Encodes a tree to a single string.
    public String serializeB(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return buildString(root, sb).toString();
    }

    private StringBuilder buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return sb.append("#").append(",");
        }

        sb.append(root.val).append(",");
        buildString(root.left, sb).append(",");
        buildString(root.right, sb);
        return sb;
    }

    /**
     * Recursive
     * Same as preorder traversal.
     * Split data by "," and use Queue to store strings.
     * Poll a value string from the queue.
     * If null node, return null.
     * Create a tree node with value.
     * Then build left and right subtrees recursively.
     */
    // Decodes your encoded data to tree.
    public TreeNode deserializeB(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String head = queue.poll();
        if ("#".equals(head)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(head));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }

}
