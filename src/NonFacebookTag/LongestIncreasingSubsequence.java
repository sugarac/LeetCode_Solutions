package NonFacebookTag;

public class LongestIncreasingSubsequence {
    /**
     * Medium (M)
     */

    /**
     * DP
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {   //
            dp[i] = 1;
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
