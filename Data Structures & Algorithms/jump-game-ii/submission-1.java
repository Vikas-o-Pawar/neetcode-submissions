class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int maxReach = 0;
        int n = nums.length;
        int currEnd = 0;

        for(int i = 0; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if(i == currEnd) {
                currEnd = maxReach;
                jumps++;
            }
        }

        return jumps;
    }
}
