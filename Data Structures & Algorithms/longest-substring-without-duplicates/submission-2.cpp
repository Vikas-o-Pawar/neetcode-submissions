class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> st;

        int i = 0;
        int j = 0; 
        int k = 0;
        
        while(j < s.length()) {
            char ch = s[j];

            while(st.find(ch) != st.end()) {
                // character repeatd
                st.erase(s[i]);
                i++;
            }

            st.insert(ch);
            k = max(k, j - i + 1);
            j++;
        }


        return k;
    }
};
