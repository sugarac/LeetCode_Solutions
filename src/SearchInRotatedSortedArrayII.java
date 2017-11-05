public class SearchInRotatedSortedArrayII {
    /**
     * Medium
     * O(logn) in average cases, but O(n) in worst cases, O(1)
     * This problem is used to inspect if we can find the worst case, e.g. [1, 1, 1, 1, 0], which is O(n).
     * So we can just traverse the array to find the target.
     * !!! But we can still use Binary Search to solve this problem.
     * We only need to add one more code line than the code of I.
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[start]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < nums[start]) {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                start++;    //the added code line
            }
        }
        if (nums[start] == target || nums[end] == target) {
            return true;
        }
        return false;
    }

    /**
     * O(n), O(1)
     */
    public boolean searchB(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }
}
