class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<string> stk;

        for(string t: tokens) {
            if(isOpt(t)) {
                int opd1 = stoi(stk.top());
                stk.pop();
                int opd2 = stoi(stk.top());
                stk.pop();  

                int result = 0;

                if(t == "+") {
                    result = opd2 + opd1;
                } else if(t == "-") {
                    result = opd2 - opd1;
                } else if(t == "*") {   
                    result = opd2 * opd1;
                } else {
                    result = opd2 / opd1;
                }

                stk.push(to_string(result));
            } else {
                stk.push(t);
            }
        }

        return stoi(stk.top());
    }

    bool isOpt(string s) {
        return (s == "+" || s == "-" || s == "*" || s == "/");
    }
};
