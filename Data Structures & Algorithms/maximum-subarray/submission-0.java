class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            max = Math.max(curr + max, curr);
            // at each step we are asking whether it is better
            // to extend the previous max value by 
            // adding to curr number, or just consider the curr number

            res = Math.max(res, max);
        }

        return res;        
    }
}