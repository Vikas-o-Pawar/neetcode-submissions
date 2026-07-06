class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        return helper(nums, n, 0, -1, dp);
    }

    public int helper(int[] nums, int n, int i, int prev, int[][] dp) {
        if(i == n) return 0;

        if(dp[i][prev + 1] > 0) {
            return dp[i][prev + 1];
        }

        int take = 0;

        if(prev == -1 || nums[i] > nums[prev]) {
            // if it's the first item, then nothing to add up to
            take = 1 + helper(nums, n, i + 1, i, dp);    
        }

        int dontTake = 0 + helper(nums, n, i + 1, prev, dp);
        dp[i][prev + 1] = Math.max(take, dontTake);

        return Math.max(take, dontTake);
    }
}