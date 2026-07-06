class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.length() != t.length()) {
            return false;
        }

        int arrS[26] = {0};
        int arrT[26] = {0};

        for(int i = 0; i < s.length(); i++) {
            char cS = s[i];
            char cT = t[i];

            int cSIdx = cS - 'a';
            int cTIdx = cT - 'a';

            arrS[cSIdx]++;
            arrT[cTIdx]++;
        }


        bool isEqual = equal(begin(arrS), end(arrS), begin(arrT));

        return isEqual;
    }
};
