package Subarray;

public class MaximumAverageSubarrayI {
    /**
     * PreSum O(n);O(1)
     */
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i > k - 2) {
                max = Math.max(max, sum);
                sum -= nums[i - k + 1];
            }
        }
        return (double) max / k;
    }
}
