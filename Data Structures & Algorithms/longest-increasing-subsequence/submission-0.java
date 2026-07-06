class Solution {
    public int lengthOfLIS(int[] nums) {
        int prev = -1; // previous index i picked
        Map<String, Integer> map = new HashMap<>();
        return helper(nums, prev, 0, map);
    }

    public int helper(int[] nums, int prev, int i, Map<String, Integer> map) {
        if(i == nums.length) {
            return 0;
        }

        String key = i + "," + prev;

        if(map.containsKey(key)) {
            return map.get(key);
        }

        int pick = 0;

        // pick
        if(prev == -1 || nums[i] > nums[prev]) {
            pick = 1 + helper(nums, i, i + 1, map);
        } 

        // don't pick
        int dontPick = helper(nums, prev, i + 1, map);
        
        map.put(key, Math.max(pick, dontPick));
        return map.get(key);
    } 
}