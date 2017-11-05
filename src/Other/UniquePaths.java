package Other;

import java.util.Arrays;

public class UniquePaths {
    /**
     * DP O(mn);O(mn)
     * However, you may have observed that each time when we update path[i][j], we only need path[i - 1][j]
     * (at the same column) and path[i][j - 1] (at the left column). So it is enough to maintain two columns
     * (the current column and the left column) instead of maintaining the full m*n matrix.
     * Now the code can be optimized to have O(min(m, n)) space complexity.
     */
    public int uniquePathsB(int m, int n) {
        if (m <= 0 || n <= 0) {
            return -1;
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     *
     */
    public int uniquePaths(int m, int n) { //record row
        if (m < n) {
            return uniquePaths(n, m);
        }

        int[] cur = new int[n];
        cur[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
//    public int uniquePaths(int m, int n) { //record column
//        if (m > n) {
//            return uniquePaths(n, m);
//        }
//
//        int[] cur = new int[m];
//        Arrays.fill(cur, 1);
//        for (int j = 1; j < n; j++) {
//            for (int i = 1; i < m; i++) {
//                cur[i] += cur[i - 1];
//            }
//        }
//        return cur[m - 1];
//    }

    /**
     * Math
     * 如果我们仔细的看这个问题背后的数学模型，其实就是机器人总共走m+n-2步，
     * 其中m-1步往下走，n-1步往右走，本质上就是一个组合问题，也就是从m+n-2个不同元素中每次取出m-1个元素的组合数。
     */
    public int uniquePathsC(int m, int n) {
        double dom = 1;
        double dedom = 1;
        int small = m<n? m-1:n-1;
        int big = m<n? n-1:m-1;
        for(int i=1;i<=small;i++)
        {
            dedom *= i;
            dom *= small+big+1-i;
        }
        return (int)(dom/dedom);
    }
}
