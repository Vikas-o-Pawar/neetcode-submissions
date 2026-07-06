class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n;
        if(n == 1) return nums[0];
        
        return Math.max(robHelper(nums, 0, end - 1), robHelper(nums, start + 1, end));
    }

    public int robHelper(int[] nums, int s, int e) {
        int p1 = 0;
        int p2 = 0;

        for(int i = s; i < e; i++) {
            int curr = Math.max(p1, p2 + nums[i]);
            p2 = p1;
            p1 = curr;
        }

        return p1;
    }
}