class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        return n == 1? nums[0]:
            Math.max(
            dp(nums, 0, n - 1),
            dp(nums, 1, n)
        );
    }

    public int dp(int[] nums, int start, int end) {
        int p1 = 0;
        int p2 = 0;

        for(int i = start; i < end; i++) {
            int curr = Math.max(p1, nums[i] + p2);
            p2 = p1;
            p1 = curr;
        }

        return p1;
    }
}