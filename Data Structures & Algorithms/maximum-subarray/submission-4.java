class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int cur = nums[i];

            res = Math.max(res + cur, cur);
            max = Math.max(max, res);
        }

        return max;
    }
}
