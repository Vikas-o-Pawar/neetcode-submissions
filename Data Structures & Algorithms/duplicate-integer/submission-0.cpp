class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        unordered_set<int> set;

        for(int n: nums) {
            if(set.find(n) != set.end()) {
                return true;
            }
            set.insert(n);
        }

        return false;
    }
};