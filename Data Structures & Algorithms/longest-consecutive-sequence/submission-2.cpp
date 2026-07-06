class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> st;
        int len = 0;

        for(auto n: nums) {
            st.insert(n);
        }

        for(int n: st) {
            int l = 0;
            if(st.find(n - 1) == st.end()) {

                while(st.find(n) != st.end()) {
                    l++;
                    n++;
                }
            }

            len = max(l, len);
        }

        return len;
    }
};
