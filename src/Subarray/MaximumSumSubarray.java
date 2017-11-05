package Subarray;

public class MaximumSumSubarray {
    /**
     * Greedy O(n); O(1)
     * Create an integer to record the max sum and the other to record prefix sum.
     * Traverse the array.
     * The max sum is always the larger one between itself and prefix sum.
     * If prefix sum is lesser than 0, discard it and recalculate prefix sum from next number.
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0); //不能合上面的交换，否则有case过不去，比如输入是：[-1]
        }
        return max;
    }

    /**
     * DP O(n);O(n) 可以优化为O(1),见下
     * maxSubArray(int A[], int i), which means the maxSubArray for A[0:i ] which must has A[i] as the end element.
     */
    public int maxSubArrayB(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
//            curMax = Math.max(curMax + nums[i], nums[i]);
//            max = Math.max(max, curMax);
        }
        return max;
    }

    /**
     * PrefixSum O(n);O(1)
     * sum(i, j) = sum(0, j) - sum(0,i - 1)
     */
    public int maxSubArrayC(int[] nums) {
        int max = nums[0];
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }

    /**
     * 分治
     * https://discuss.leetcode.com/topic/426/how-to-solve-maximum-subarray-by-using-the-divide-and-conquer-approach
     */
}
