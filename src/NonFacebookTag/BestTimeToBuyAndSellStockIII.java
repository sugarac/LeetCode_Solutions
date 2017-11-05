package NonFacebookTag;

public class BestTimeToBuyAndSellStockIII {
    /**
     * Hard
     * follow up:
     * 1.(G)有3n个数围成一个环，取走其中一个的话会顺带去掉这个数相邻的两个数（这两个不计入总和），剩下的继续围成环，问取走n个数构成总和的最大值。
     */

    /**
     * DP O(n);O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for (int p : prices) {
            buy1 = Math.max(buy1, -p);//-p表示第一次买股票时，自己是贴钱的；当股票一直跌时，假设以最低价格买入，即低买
            sell1 = Math.max(sell1, buy1 + p);//当股票一直涨时，以最高价格卖出，即高卖
            buy2 = Math.max(buy2, sell1 - p);//遇到比第一次卖出的价格便宜的股票时，假设第二次买，保证赚钱
            sell2 = Math.max(sell2, buy2 + p);//当假设第二次买的股票涨时，卖出
        }
        return sell2;
    }

    /**
     * DP solution which generalizes to k transactions O(kn);O(n)
     */
    public int maxProfitB(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[] dp = new int[prices.length];//k == 0, dp[i] = 0
        int k = 2, tmpMax;
        for (int i = 1; i <= k; i++) {
            tmpMax = dp[0] - prices[0];
            dp[0] = 0;
            for (int j = 1; j < prices.length; j++) {
                tmpMax = Math.max(tmpMax, dp[j] - prices[j]);
                dp[j] = Math.max(dp[j - 1], prices[j] + tmpMax);
            }
        }
        return dp[prices.length - 1];
    }
}
