class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        for(int i = 1; i < n; i++) {
            int curr = nums[i];
            int p1 = curr * max;
            int p2 = curr * min;

            max = Math.max(curr, Math.max(p1, p2));
            min = Math.min(curr, Math.min(p1, p2)); 

            res = Math.max(max, res);
        }

        return res;
    }
}
