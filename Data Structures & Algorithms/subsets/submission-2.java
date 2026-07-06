class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 0, nums.length, nums);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> ls, int start, int n, int[] nums) {

        res.add(new ArrayList<>(ls));
        
        for(int i = start; i < n; i++) {
            ls.add(nums[i]);
            helper(res, ls, i + 1, n, nums);
            ls.removeLast();
        }
    }
}