class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, candidates.length, target, res, new ArrayList<>());
        return res;
    }

    public void helper(int[] candidates, int start, int n, int target, List<List<Integer>> res, List<Integer> ls) {
        if(target < 0) {
            return;
        }

        if(target == 0) {
            res.add(new ArrayList<>(ls));
        }

        for(int i = start; i < n; i++) {
            if(i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            ls.add(candidates[i]);
            target -= candidates[i];

            helper(candidates, i + 1, n, target, res, ls);

            ls.removeLast();
            target += candidates[i];
        }
    }
}