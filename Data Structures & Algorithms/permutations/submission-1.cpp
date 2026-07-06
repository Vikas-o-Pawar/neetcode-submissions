class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> result;

        permuteHelper(nums, n, result, 0);

        return result;
    }

    void permuteHelper(vector<int>& nums, int n, vector<vector<int>>& result, int index) {
        if(index == n) {
            vector<int> v;

            for(int k : nums) {
                v.push_back(k);
            }

            result.push_back(v);
            return;
        }

        for(int i = index; i < n; i++) {
            swap(nums, i, index);
            permuteHelper(nums, n, result, index + 1);
            swap(nums, i, index);
        }
    }

    void swap(vector<int>& nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
};
