package Other;

public class HouseRobber {
    /**
     * Easy 都用的是soul-machine的写法，我觉得比较好
     */

    /**
     * DP O(n);O(n)
     */
    public int rob(int[] nums) { //坐标型DP
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

/*不需要把数组长度设置为n+1
DP O(n);O(n) 九章强化班讲的写法，不推荐*/
//    public int rob(int[] nums) {//序列型DP做法
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int n = nums.length;
//        int[]  dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = nums[0];
//        for (int i = 2; i <= n; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
//        }
//        return dp[n];
//    }//jj
    /**
     * DP O(n);O(1)
     */
    public int robB(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int even = nums[0];
        int odd = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            if (i % 2 == 0) {
                even = Math.max(even + nums[i], odd);
            } else {
                odd = Math.max(odd + nums[i], even);
            }
        }
        return Math.max(even, odd);
    }

    /**
     * DP O(n);O(1) 九章强化班讲的写法，不推荐
     */
//    public int robB(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int n = nums.length;
//        int[] dp = new int[2];
//        dp[0] = 0;
//        dp[1] = nums[0];
//        for (int i = 2; i <= n; i++) {
//            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i - 1]);
//        }
//        return dp[n % 2];
//    }
}
