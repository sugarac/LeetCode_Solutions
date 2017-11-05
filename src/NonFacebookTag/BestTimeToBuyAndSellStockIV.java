package NonFacebookTag;

public class BestTimeToBuyAndSellStockIV {
    /**
     * Hard ()G
     */

    /**
     * DP O(kn);O(kn)
     * dp[i, j] represents the max profit at day j with at most i transactions.
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     * = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     *
     * tmpMax means the maximum profit of just doing at most i-1 transactions, using at most first j-1 prices,
     * and buying the stock at price[j] - this is used for the next loop.
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        if (k >= n / 2) { //avoid TLE
            int max = 0;
            for (int i = 1; i < n; i++) {
                max += Math.max(0, prices[i] - prices[i - 1]);
            }
            return max;
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int preMax = -prices[0];
            for (int j = 1; j < n; j++) {
//                curMax = Math.max(dp[i - 1][j - 1] + Math.max(0, prices[j] - prices[j - 1]), curMax + prices[j] - prices[j - 1]);
//                dp[i][j] = Math.max(dp[i][j - 1], curMax);
//                curMax = Math.max(curMax, dp[i - 1][j] - prices[j]);
//                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + curMax);
                //at this price j we don't sell stock; we sell our current holding stock
                dp[i][j] = Math.max(dp[i][j - 1], preMax + prices[j]);
                //we holding a lowest price stock; we buy this stock
                preMax = Math.max(preMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }

    /**
     * DP O(kn);O(n)
     */
    public int maxProfitB(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        if (k >= n / 2) { //avoid TLE
            int max = 0;
            for (int i = 1; i < n; i++) {
                max += Math.max(0, prices[i] - prices[i - 1]);
            }
            return max;
        }

        int[] dp = new int[n];
        for (int i = 1; i <= k; i++) {
//            tmpMax = dp[0] - prices[0];
//            dp[0] = 0;
            int curMax = -prices[0];
            for (int j = 1; j < n; j++) {
                curMax = Math.max(curMax, dp[j] - prices[j]);
                dp[j] = Math.max(dp[j - 1], prices[j] + curMax);
            }
        }
        return dp[n - 1];
    }
}
