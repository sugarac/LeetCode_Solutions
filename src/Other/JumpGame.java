package Other;

public class JumpGame {
    /**
     * Greedy O(n); O(1)
     * Traverse the array and update the max index that we can reach.
     * If the max index is larger than n - 1, return true.
     * 由于每层最多可以跳 A[i] 步，也可以跳0或1步，因此如果能到达最高层，则说明每一层都可以到达。有了这个条件，说明可以用贪心法。
     * 思路一：正向，从0出发，一层一层网上跳，看最后能不能超过最高层，能超过，说明能到达，否则不能到达。
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int n = nums.length;
        int maxReach = 0;
        for (int i = 0; i < n && i <= maxReach; i++) { //n不能改成n - 1,考虑输入：[0]
            maxReach = Math.max(i + nums[i], maxReach);
            if (maxReach >= n - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * DP O(n^2);O(n) 会超时，题目原意也是想让用贪心做。
     * dp[i] represents if we are able to reach the index i.
     */
    public boolean canJumpB(int[] nums) {
         if (nums == null || nums.length == 0) {
             return false;
         }

         int n = nums.length;
         boolean[] dp = new boolean[n];
         dp[0] = true;
         for (int i  = 1; i < n ; i++) {
             for (int j = 0; j < i; j++) {
                 if (dp[j] && j + nums[j] >= i) {
                     dp[i] = true;
                     break;
                 }
             }
         }
         return dp[n - 1];
     }
}
