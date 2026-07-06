class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            int pMax = curr * max;
            int pMin = curr * min;

            max = Math.max(curr, Math.max(pMax, pMin));
            min = Math.min(curr, Math.min(pMax, pMin));

            res = Math.max(res, max);
        }

        return res;        
    }
}
