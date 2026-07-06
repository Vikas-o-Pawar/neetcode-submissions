class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        if(n == 1) return true;

        for(int i = 0; i < n - 1; i++) {
            int steps = nums[i];

            if(i != 0 && !dp[i]) return false;

            dp[i] = true;
            int j = i + 1;

            while(steps != 0) {
                dp[j] = true;
                j++;
                if(j == n) return true;
                steps--;
            }
        }

        return dp[n - 1];
    }
}
