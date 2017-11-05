package Other;

public class FindMinimumInRotatedSortedArrayII {
    /**
     * Fake Binary Search O(logn); O(1)
     * Find first element that is less than or equal to the last number of array.
     * If meet duplicates, end minus one.
     * Returns the smaller of nums[start] and nums[end].
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end--;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}
