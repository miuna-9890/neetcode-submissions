class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] amt = new int[amount + 1];
        Arrays.fill(amt, -2);
        
        int result = dfs(coins, amount, amt);

        return result == Integer.MAX_VALUE/2 ? -1 : result;
        
    }

    public int dfs(int[] coins, int amount, int[] amt) {
        if (amount == 0) {
            return 0;
        }

        if (amt[amount] != -2) {
            return amt[amount];
        }

        int minCoins = Integer.MAX_VALUE/2;

        for (int coin: coins) {
            if (coin <= amount) {
                int result = 1 + dfs(coins, amount - coin, amt);
                minCoins = Math.min(minCoins, result);
            }
        }

        amt[amount] = minCoins; 

        return minCoins;
    }
}
