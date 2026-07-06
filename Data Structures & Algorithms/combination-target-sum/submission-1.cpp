class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        std::sort(nums.begin(), nums.end());
        vector<vector<int>> vec;
        vector<int> v;
        dfs(0, vec, v, target, nums);
        return vec;
    }

    void dfs(int start, vector<vector<int>> &vec, vector<int> &v, int target, vector<int> &nums) {
        if(target < 0) {
            return;
        }

        if(target == 0) {
            vector<int> v2(v);
            vec.push_back(v2);
            return;
        }

        for(int i = start; i < nums.size(); i++) {
            target -= nums[i];
            v.push_back(nums[i]);

            dfs(i, vec, v, target, nums);

            target += nums[i];
            v.pop_back();
        }
    }
};
