class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[][] dp = new int[m + 1][amount + 1];

        for(int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }

        for(int i = 1; i <= m; i++) {
            for(int a = 1; a <= amount; a++) {
                int ele = coins[i - 1];

                if(ele <= a) {
                    dp[i][a] = Math.min(dp[i-1][a], dp[i][a-ele] + 1); 
                } else {
                    dp[i][a] = dp[i - 1][a];
                }
            }
        }
        return dp[m][amount] == Integer.MAX_VALUE - 1? - 1: dp[m][amount];
    }
}
