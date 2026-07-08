class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        boolean[] dp = new boolean[n];
        int start = 0;
        int maxLen = 1;

        for(int i = n - 1; i >= 0; i--) {
            dp[i] = true; // single character
            // we start i from n - 1 coz we need i + 1 (dp[i + 1][j - 1])
            // i need the data of the next row

            for(int j = n - 1; j > i; j--) {
                dp[j] = s.charAt(i) == s.charAt(j) && (j - i == 1 || dp[j - 1]);
                // j - i == 1 is fo two char palindromes
                // dp[j - 1] is the equivalent of dp[i + 1][j -1]
                // We iterate j from right to left so dp[j - 1]
                // still represents dp[i + 1][j - 1] before it gets overwritten.

                if(dp[j] && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}