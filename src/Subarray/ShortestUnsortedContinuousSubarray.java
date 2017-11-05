package Subarray;

public class ShortestUnsortedContinuousSubarray {
    /**
     * 同向Two Pointers O(n);O(1)
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int left = -1;
        int right = -2;
        int n = nums.length;
        int max = nums[0];
        int min = nums[n - 1];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]); //当前数和左边数最大的那个
            if (nums[i] < max) { //当前数比左边的数小，无序
                right = i;
            }
            min = Math.min(min, nums[n - 1 - i]);
            if (nums[n - 1 - i] > min) {
                left = n - 1 - i;
            }
        }
        return right - left + 1;
    }

    public int findUnsortedSubarrayB(int[] nums) {
        int n = nums.length;
        int right = 0;
        int rightMax = Integer.MIN_VALUE;
        int left = n - 1;
        int leftMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (rightMax <= nums[i]) {
                rightMax = nums[i];
            } else {
                right = i;
            }
            int j = n - i - 1;
            if (leftMin >= nums[j]) {
                leftMin = nums[j];
            } else {
                left = j;
            }
        }
        return left <= right ? right - left + 1 : 0;
    }
}
