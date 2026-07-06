class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, new ArrayList<>(), 0, candidates, target);

        return result;
    }

    public void dfs(List<List<Integer>> res, List<Integer> ls, int start, int[] arr, int target) {
        if(target < 0) {
            return;
        }

        if(target == 0) {
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int i = start; i < arr.length; i++) {
            if(i > start && arr[i] == arr[i - 1]) 
                continue;
                
            target -= arr[i];
            ls.add(arr[i]);

            dfs(res, ls, i + 1, arr, target);

            target += arr[i];
            ls.remove(ls.size() - 1);
        }

        return;
    }
}
