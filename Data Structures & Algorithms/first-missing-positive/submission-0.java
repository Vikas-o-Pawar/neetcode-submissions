class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int p = 1;

        while(p < Integer.MAX_VALUE) {
            if(!map.containsKey(p)) return p;
            p++;
        }

        return Integer.MAX_VALUE;
    }
}