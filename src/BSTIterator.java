import java.util.Stack;

public class BSTIterator {
    /**
     * Stack O(1); O(h)|
     * Use Stack to store leftmost left descendants from root.
     * When call hasNext(), check if stack is empty, if no, return true, otherwise false.
     * When call next(), pop one element and process its right child as new root.
     * As the next function can be called n times at most, and the pushLeft function push n nodes at most in total, so the amortized time complexity is O(1).
     */
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    //    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    //    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        pushLeft(node.right);
        return node.val;
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
