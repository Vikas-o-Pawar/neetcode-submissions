class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0: 1;

        for(int i = 2; i <= n; i++) {
            int onechar = Integer.parseInt(s.substring(i - 1, i));
            int twochar = Integer.parseInt(s.substring(i - 2, i));

            if(onechar >= 1) dp[i] += dp[i - 1];
            if(twochar >= 10 && twochar <= 26) dp[i] += dp[i - 2];
        }

        return dp[n];
    }
}
