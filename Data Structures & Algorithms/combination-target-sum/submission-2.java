class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, 0, 0, candidates.length, res, new ArrayList<>());
        return res;
    }

    public void helper(int[] candidates, int target, int sum, int start, int n, List<List<Integer>> res, List<Integer> ls) {
        if(sum > target) {
            return;
        }

        if(sum == target) {
            res.add(new ArrayList<>(ls));
        }

        for(int i = start; i < n; i++) {
            sum += candidates[i];
            ls.add(candidates[i]);
            helper(candidates, target, sum, i , n, res, ls);

            ls.removeLast();
            sum -= candidates[i];
        }
    }  
}