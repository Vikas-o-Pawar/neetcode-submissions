class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int target = 0;
        for(int k: nums) target += k;

        int[][] dp = new int[n][target];

        return helper(nums, target, 0, 0, n, dp); 
    }

    public boolean helper(int[] nums, int target, int sum, int i, int n, int[][] dp) {
        if(i == n) {
            return false;
        }

        if(dp[i][sum] > 0) {
            return false;
        }
        
        int diff = target - sum;

        if(diff == sum) {
            return true;
        }


        // pick this number
        boolean pick = helper(nums, target, sum + nums[i], i + 1, n, dp);

        if(pick) return true;

        boolean dontPick = helper(nums, target, sum, i + 1, n, dp);

        if(dontPick) return true;
        dp[i][sum] = 1;
        
        return false;
    }
}