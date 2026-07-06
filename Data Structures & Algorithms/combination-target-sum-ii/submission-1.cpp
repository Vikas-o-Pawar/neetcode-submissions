class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> result;

        vector<int> vc;

        dfs(0, result, vc, candidates, target);

        return result;
    }


    void dfs(int start, vector<vector<int>>& result, vector<int>& vc, vector<int>& candidates, int target) {
        if(target < 0) {
            return;
        }

        if(target == 0) {
            vector<int> vc2 = vc;
            result.push_back(vc2);
            return;
        }

        if(start < candidates.size() && candidates[start] > target) {
            return;
        }

        for(int i = start; i < candidates.size(); i++) {
            if(i > start && candidates[i] == candidates[i-1]) {
                continue;
            }

            target -= candidates[i];
            vc.push_back(candidates[i]);

            dfs(i + 1, result, vc, candidates, target);

            target += candidates[i];
            vc.pop_back();
        }

        return;
    }
};