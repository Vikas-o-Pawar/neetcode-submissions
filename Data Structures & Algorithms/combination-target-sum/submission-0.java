class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, 0, new ArrayList<>(), nums, target);
        return res;
    }

    void dfs(List<List<Integer>> res, int start, List<Integer> ls, int[] nums, int target) {
        if(target < 0) {
            return;
        }

        if(target == 0) {
            List<Integer> l = new ArrayList<>(ls);
            res.add(l);
            return;
        }

        for(int i = start; i < nums.length; i++) {
            target -= nums[i];
            ls.add(nums[i]);

            dfs(res, i,ls, nums, target);

            target += nums[i];
            ls.remove(ls.size() - 1);
        }
    }
}
