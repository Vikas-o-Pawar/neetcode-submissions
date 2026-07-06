class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        int n = nums.length;

        for(int i = 1; i < n; i++) {
            result ^= nums[i];
        }

        return result;
    }
}
