class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(0, nums, new ArrayList<>(), result, nums.length);
        return result;
    }

    public void dfs(int start, int[] nums, List<Integer> ls, List<List<Integer>> res, int n) {
        List<Integer> copy = new ArrayList<>();

        for(int k: ls) {
            copy.add(k);
        }
        res.add(copy);

        for(int i = start; i < n; i++) {
            ls.add(nums[i]);
            dfs(i + 1, nums, ls, res, n);
            ls.remove(ls.size() - 1);
        }
    }
}
