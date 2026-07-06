class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < n - 1; i++) {
            int steps = nums[i];
            int j = i + 1;

            while(steps != 0) {
                if(j >= n) break;
                dp[j] = Math.min(dp[j], 1 + dp[i]);
                j++;
                steps--;
            }
        }

        return dp[n - 1];
    }
}