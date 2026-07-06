class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int k : nums) sum += k;
        int[][] dp = new int[n][2 * sum + 1];
        for(int[] d: dp) Arrays.fill(d, -1);
        return helper(nums, target, sum, 0, n, dp);
    }

    public int helper(int[] nums, int target, int sum, int i, int n, int[][] dp) {
        if(target > sum || target < -sum) return 0;

        if(i == n) {
            return target == 0? 1: 0;
        }

        if(dp[i][target + sum] != -1) {
            return dp[i][target + sum];
        }
        
        int add = helper(nums, target + nums[i], sum, i + 1, n, dp);
        int sub = helper(nums, target - nums[i], sum, i + 1, n, dp);

        return dp[i][target + sum] = add + sub;
    }
}
