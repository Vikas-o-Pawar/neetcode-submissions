class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for(int i = 0; i < coins.length; i++) {
            int coin = coins[i];

            for(int j = 1; j <= amount; j++) {
                if(j >= coin) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                } 
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}