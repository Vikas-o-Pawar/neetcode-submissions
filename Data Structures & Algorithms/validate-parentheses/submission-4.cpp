class Solution {
public:
    bool isValid(string s) {
        stack<char> st;

        for(int i = 0; i < s.length(); i++) {
            char ch = s[i];
            bool isEmpty = st.size() == 0? true: false;

            if(ch == '[' || ch == '(' || ch == '{') {
                st.push(ch);
            } else if(isClosedBracket(st, ch)) {
                st.pop();
            } else {
                return false;
            }
        }

        if(st.size() == 0) {
            return true;
        }

        return false;
    }

    bool isClosedBracket(stack<char> &st, char c) {
        bool isEmpty = st.size() == 0? true: false;

        if(!isEmpty && (
            (c == ')' && st.top() == '(') ||
            (c == '}' && st.top() == '{') || 
            (c == ']' && st.top() == '[')
            )) {
            return true;
        } 
        
        return false;
    }
};
