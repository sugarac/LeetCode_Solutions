package Other;

public class ClosestBinarySearchTreeValue {
    /**
     * O(h); O(1)
     * Set root node as current node and then Search BST.
     * While current node is not null, update result if the value of current node is closer to target compared with result.
     * If the value of current node > target, move current node to left, otherwise right.
     */
    public int closestValue(TreeNode root, double target) {
        TreeNode cur = root;
        int res = cur.val;
        while (cur != null) {
            if (Math.abs(target - cur.val) < Math.abs(target - res)) {
                res = cur.val;
            }
            cur = cur.val > target ? cur.left : cur.right; //不能和上面的if交换位置,这样写很巧妙，不用判断left和right是否为空
        }
        return res;
    }
}
