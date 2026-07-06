class Solution {
    public int rob(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        int n1 = rob(nums, map, n - 1);
        int n2 = rob(nums, map, n - 2);

        return Math.max(n1, n2);
    }

    public int rob(int[] nums, Map<Integer, Integer> map, int n) {
        if(map.containsKey(n)) return map.get(n);

        if(n == 0) return nums[0];

        if(n == 1) {
            return nums[1];
        }

        if(n < 0) {
            return 0;
        }

        int n1 = rob(nums, map, n - 2);
        int n2 = rob(nums, map, n - 3);

        map.put(n, nums[n] + Math.max(n1, n2));

        return map.get(n);
    }
}