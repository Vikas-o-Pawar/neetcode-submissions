class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int start = 0;
        int maxLen = 1;

        boolean[][] dp = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            dp[i][i] = true;

            if(i != n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        int len = 3;

        while(len <= n) {
            for(int i = 0; i <= n - len; i++) {
                int reach = i + len - 1;

                if(s.charAt(i) == s.charAt(reach) && dp[i + 1][reach - 1]) {
                    start = i;
                    dp[i][reach] = true;
                    maxLen = len;
                }
            }
            len++;
        }

        return s.substring(start, start + maxLen);
    }
}