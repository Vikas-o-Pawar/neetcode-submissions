class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> vec;
        vector<int> v;
        int n = nums.size();

        subsetsHelper(0, nums, vec, v, n);
        return vec;
    }

    void subsetsHelper(int start, vector<int> &nums, vector<vector<int>> &vec, vector<int> &v, int n) {
        vector<int> v2(v);
        vec.push_back(v2);
        
        for(int i = start; i < n; i++) {
            v.push_back(nums[i]);
            subsetsHelper(i + 1, nums, vec, v, n);
            v.pop_back();
        }
    }
};
