class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[2][n];
        if(n == 1) return nums[0];

        int k = dp(nums, n, n - 1, true, memo);

        return k;
    }

    public int dp(int[] nums, int n, int i, boolean lastPicked, Integer[][] memo) {
        int row = lastPicked ? 1: 0;
        if(lastPicked && i == 0) return 0;
        if(i < 0) return 0;
        if(memo[row][i] != null) return memo[row][i];

        int pick = nums[i] + dp(nums, n, i - 2, lastPicked, memo);

        if(i == n - 1)  lastPicked = false;

        int skip = dp(nums, n, i - 1, lastPicked, memo);

        memo[row][i] = Math.max(pick, skip);
        return memo[row][i];
    }
}