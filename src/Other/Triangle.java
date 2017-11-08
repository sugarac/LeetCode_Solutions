package Other;

import java.util.List;

public class Triangle {
    /**
     * Solution1: DP O(n^2); O(n)
     * dp[i][j] means the min path sum from the jth node in the ith row to the last row.
     * dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j)
     * Then we can find that the row dp[i + 1] would be useless after dp[i] is computed,
     * so we can simply set dp as a 1D array, and iteratively update itself.
     * dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j), return dp[0].
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }

        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
