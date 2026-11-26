class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(dp, 0, prices, 1);
        
    }

    public int helper(int[][] dp, int i, int[] prices, int canBuy) {
        if (i >= prices.length) {
            return 0;
        }

        if (dp[i][canBuy] != -1) {
            return dp[i][canBuy];
        }

        if (canBuy == 1) {
           int buy = -prices[i] + helper(dp, i+1, prices, 0);
           int skip = helper(dp, i+1, prices, 1);
           dp[i][canBuy] = Math.max(buy, skip);
        } else {
            int sell = prices[i] + helper(dp, i+2, prices, 1);
            int hold = helper(dp, i+1, prices, 0);
            dp[i][canBuy] = Math.max(sell, hold);
        }

        return dp[i][canBuy];

    }
}
