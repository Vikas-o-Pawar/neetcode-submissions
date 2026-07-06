class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> vec;
        int n = nums.size();
        
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];

                if(sum == target) {
                    vec.push_back(i);
                    vec.push_back(j);
                    return vec;
                }
            }
        }

        vec.push_back(-1);
        vec.push_back(-1);
        return vec;
    }
};
