class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        int cnt = 0;

        for(int i = n - 1; i >= 0; i--) {
            dp[i] = true;
            cnt++;

            for(int j = n - 1; j > i; j--) {
                dp[j] = s.charAt(i) == s.charAt(j) && (j - i == 1 || dp[j - 1]);
                cnt += (dp[j] ? 1: 0);
            }
        }

        return cnt;
    }
}