public class MaximalSquare {
    /**
     * Medium (F,Ap,Ai)
     */

    /**
     * DP O(mn);O(mn)
     * state: dp[i][j] represents maximal side length that can be achieved at point(i - 1, j - 1)
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        //不建议在这里初始化第0行和第0列，可以在下面的循环中一起赋值，大大节省代码量，但这样做记得要将数组各加一行一列。

        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    /**
     * DP O(mn);O(m)
     * As can be seen, each time when we update size[i][j], we only need size[i][j - 1], size[i - 1][j - 1](at the previous left column)
     * and size[i - 1][j] (at the current column).
     * So we do not need to maintain the full m*n matrix. In fact, keeping two columns is enough.
     * Now we have the following optimized solution.
     */
    public int maximalSquareB(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[] dp = new int[matrix[0].length + 1];
        int pre = 0;

        int max = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], pre), dp[j]) + 1;
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                pre = temp;
            }
        }
        return max * max;
    }
}
