package LowFrequency;

public class TargetSum {
    /**
     * Medium (F,G)
     */

    /**
     * 数学推导 + DP O(sum*n);O(sum)
     * The original problem statement is equivalent to:
     * Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target
     * So the original problem has been converted to a subset sum problem as follows:
     * Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
     */
    public int findTargetSumWays(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return s > sum || s < -sum || (s + sum) % 2 == 1 ? 0 : subsetSum(nums, (s + sum) / 2);
    }

    private int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int num : nums) {
//            for (int i = num; i <= s; i++) { //这么写就不对，不知道为什么，应该是一样的啊
//                dp[i] += dp[i - num]; //应该是这里的dp[i]只能从后往前算，因为重复元素也是有序的，从左到右排列，不能认为是简单的组合
//            }
            for (int i = s; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[s];
    }

    public int findTargetSumWaysB(int[] nums, int s) { //不太能理解，先放着
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (s > sum || s < -sum) {
            return 0;
        }

        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] next = new int[2 * sum + 1];
            for (int j = 0; j < next.length; j++) {
                if (dp[j] != 0) {
                    next[j + nums[i]] += dp[j];
                    next[j - nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        return dp[s + sum];
    }
}
