class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> map1;

        for(int i = 0; i < nums.size(); i++) {
            map1[nums[i]] = i;
        }

        for(int i = 0; i < nums.size(); i++) {
            int diff = target - nums[i];
            if(map1.find(diff) != map1.end() && map1[diff] != i) {
                return vector<int>{i, map1[diff]};
            }
        }

        return vector<int>{-1, -1};
    }
};
