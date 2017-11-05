package Other;

public class JumpGameII {
    /**
     * Greedy O(n);O(1)
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int count = 0;
        int preMax = 0;
        int curMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curMax = Math.max(curMax, i + nums[i]); //the longest distance that we can jump to from i
            if (i == preMax) {
                preMax = curMax;
                count++;
/*                if (preMax >= nums.length) { //加上剪枝这段代码，运行时间反而加长了，因为判断的次数要比剪枝节省的次数多很多
                    return count;
                }*/
            }
        }
        return count;
    }

/*    public int jump(int[] nums) { //shit
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != n && nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    i = nums[j] + j;
                    System.out.println(i + " " + dp[i]);
                    break;
                }
            }
        }
        return dp[n - 1];
    }*/
}
