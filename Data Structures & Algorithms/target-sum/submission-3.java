class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        return findTarget(nums, target, 0, map, 0);
    }

    public int findTarget(int[] nums, int target, int sum, Map<String, Integer> map, int n) {
        if(n == nums.length) {
            return sum == target? 1: 0;
        }

        String key = n + "," + sum;

        if(map.containsKey(key)) {
            return map.get(key);
        }

        int addNum = findTarget(nums, target, sum + nums[n], map, n + 1);
        int subNum = findTarget(nums, target, sum - nums[n], map, n + 1);

        map.put(key, addNum + subNum);
        return addNum + subNum;
    }
}