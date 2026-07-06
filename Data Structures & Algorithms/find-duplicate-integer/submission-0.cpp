class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        unordered_set<int> st;

        for(int n : nums) {
            if(st.find(n) != st.end()) {
                return n;
            }
            st.insert(n);
        }

        return -1;
    }
};
