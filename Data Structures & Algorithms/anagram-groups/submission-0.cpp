class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> vec;
        map<string, vector<string>> mp;

        for(string str: strs) {
            string sorted_str = str;
            sort(sorted_str.begin(), sorted_str.end());
            mp[sorted_str].push_back(str);
        }

        for (auto &m: mp) {
            vec.push_back(m.second);
        }

        return vec;    
    }
};
