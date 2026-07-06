class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 1;

        for(int i = 0; i < n; i++)
            dp[i][i] = true;
        
        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                maxLen = 2;
                start = i;
                dp[i][i + 1] = true;
            }
        }
        // i + len - 1 < n;
        // i < n - len + 1;
        // i <= n;

        for(int len = 3; len <= n; len++) {
            for(int i = 0; i <= n - len; i++) {
                int reach = i + len - 1;

                if(s.charAt(i) == s.charAt(reach) && dp[i + 1][reach - 1]) {
                    maxLen = len;
                    start = i;
                    dp[i][reach] = true;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
