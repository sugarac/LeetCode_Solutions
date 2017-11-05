public class BestTimeToBuyAndSellStock {
    /**
     * Easy (F,U,A,M,B)
     * follow up:
     * 1.LC 122. Best Time to Buy and Sell Stock II
     * 2.LC 123. Best Time to Buy and Sell Stock III
     * 3.返回买入和卖出时间的Index
     */

    /**
     * Solution1: DP O(n); O(1)
     * Max profit = max price - min price.
     * Use two variables to record min price and max profit.
     * Traverse the array. Min price is the larger one between itself and current price.
     * Max profit is the larger one between itself and current price – min price.
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int max = 0;
        int minPrice = prices[0];
        for (int curPrice : prices) {
            minPrice = Math.min(minPrice, curPrice);
            max = Math.max(max, curPrice - minPrice);
        }
        return max;
    }

    /**
     * Kadane's Algorithm O(n);O(1)
     * The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm. Since no body has mentioned this so far,
     * I thought it's a good thing for everybody to know. All the straight forward solution should work,
     * but if the interviewer twists the question slightly by giving the difference array of prices, Ex: for {1, 7, 4, 11},
     * if he gives {0, 6, -3, 7}, you might end up being confused. Here, the logic is to calculate the difference
     * (maxCur += prices[i] - prices[i-1]) of the original array, and find a contiguous subarray giving maximum profit.
     * If the difference falls below 0, reset it to zero.
     */
    public int maxProfitB(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxCur = 0;
        int maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur + prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
