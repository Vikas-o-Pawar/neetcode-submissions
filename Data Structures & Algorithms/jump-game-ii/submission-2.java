class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            int num = nums[i];

            int nextIdx = i + num;
            if(nextIdx == i) continue; // element is 0

            int k = i + 1;

            while(k <= nextIdx) {
                if(k == n) break;
                dp[k] = Math.min(
                    dp[k],
                    dp[i] + 1
                );
                k++;
            }

        }

        return dp[n - 1];
    }
}