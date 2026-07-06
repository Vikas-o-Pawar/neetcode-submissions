class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        Map<String, Integer> map = new HashMap<>();
        int k = helper(nums, 0, n - 1, map);
        return k;
    }

    public int helper(int[] nums, int value, int n, Map<String, Integer> map) {
        if(n <= -1) {
            return 0;
        }

        String key = n + "," + value;
        if(map.containsKey(key)) {
            return map.get(key);
        }

        int take = nums[n] + helper(nums, value, n - 2, map);
        int notTake = helper(nums, value, n - 1, map);

        map.put(key, Math.max(take, notTake));
        return Math.max(take, notTake);
    }
}