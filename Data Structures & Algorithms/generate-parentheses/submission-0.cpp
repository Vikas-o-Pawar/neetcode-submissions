class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> vc;
        string sb = "";
        dfs(n, 0, 0, vc, sb);
        return vc;   
    }

    void dfs(int n, int cL, int cR, vector<string>& vc, string & sb) {
        if(n * 2 == sb.length()) {
            vc.push_back(sb);
            return;
        }

        if(cL < n) {
            dfs(n, cL + 1, cR, vc, sb+='(');
            sb.erase(sb.length() - 1);
        }

        if(cR < cL) {
            dfs(n, cL, cR + 1, vc, sb+=')');
            sb.erase(sb.length() - 1);
        }
    }
};
