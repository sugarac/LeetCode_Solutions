package Other;

public class ConvertSortedArraytoBST {
    /**
     * Solution1: Recursive O(n); O(h)
     * Calculate the index of middle number of given array.
     * Create a node with the value of middle number.
     * Then generate the left and right children recursively.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = toBST(nums, start, mid - 1);
        node.right = toBST(nums, mid + 1, end);
        return node;
    }
}
