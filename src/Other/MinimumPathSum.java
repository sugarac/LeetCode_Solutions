package Other;

public class MinimumPathSum {
    /**
     * Solution1: DP O(mn); O(mn)
     * dp[i][j] means minimum path sum to arrive at point (i, j) from (0, 0).
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1].
     * Row 0 and column 0 are initialized to 1.
     * Return dp[m-1][n-1].
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                System.out.println(dp[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * Solution2: O(mn); O(min(m, n))
     * dp[i][j] only relys on dp[i - 1][j](at upper row, up), and dp[i][j – 1](at same row, left).
     * So only need a linear array to record upper row.
     */
    public int minPathSumB(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] cur = new int[n];
        cur[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            cur[j] = cur[j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            cur[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                cur[j] = Math.min(cur[j], cur[j - 1]) + grid[i][j]; //上，左
            }
        }
        return cur[n - 1];
    }
}
