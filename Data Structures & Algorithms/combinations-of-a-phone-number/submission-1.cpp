class Solution {
public:
    vector<string> letterCombinations(string digits) {
        map<char, string> mp;
        initMap(mp);
        vector<string> vc;
        string sb = "";

        for(auto m: mp) {
            cout<< m.first << " " << m.second << endl;
        }

        backtrack(digits, sb, vc, 0, mp);

        return vc;
    }

    void backtrack(string & digits, string & sb, vector<string>& vc, int start, map<char, string>& mp) {
        if(start == digits.length()) {
            if(digits.length() > 0) {
                vc.push_back(sb);
            }

            return;
        }
        
        string digitsStr = mp[digits[start]];

        for(int i=0; i < digitsStr.length(); i++) {
            sb += digitsStr[i];
            backtrack(digits, sb, vc, start + 1, mp);
            sb.erase(sb.length() - 1, 1);
        }

    } 


    void initMap(map<char, string> &mp) {
        mp['2'] = "abc";
        mp['3'] = "def";
        mp['4'] = "ghi";
        mp['5'] = "jkl";
        mp['6'] = "mno";
        mp['7'] = "pqrs";
        mp['8'] = "tuv";
        mp['9'] = "wxyz";
    }
};
