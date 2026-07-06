class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(coins, amount, 0, n, dp);
    }

    public int helper(int[] coins, int amount, int i, int n, int[][] dp) {
        if(amount < 0 || i == n) {
            return 0;
        }

        if(amount == 0) {
            return 1;
        }

        if(dp[i][amount] >= 0) {
            return dp[i][amount];
        }

        int pick = helper(coins, amount - coins[i], i, n, dp);
        int dontPick = helper(coins, amount, i + 1, n, dp);
        return dp[i][amount] = pick + dontPick;
    }
}