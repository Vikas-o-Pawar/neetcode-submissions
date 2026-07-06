class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        std::sort(nums.begin(), nums.end());

        vector<vector<int>> vc;
        vector<int> ls;
        int n = nums.size();

        backtrack(nums, 0, n, vc, ls);

        return vc;
    }

    void backtrack(vector<int>& nums, int start, int n, vector<vector<int>>& vc, vector<int>& ls) {
        vc.push_back(ls);

        for(int i = start; i < n; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            ls.push_back(nums[i]);
            backtrack(nums, i + 1, n, vc, ls);
            ls.pop_back();
        }
    }
};
