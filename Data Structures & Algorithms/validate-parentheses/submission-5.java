class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);

            // if it's an opening bracket, then push
            if(bracket == '(' || bracket == '[' || bracket == '{') {
                stk.push(bracket);
            } else if(
                !stk.isEmpty() && 
                ((bracket == ']' && stk.peek() == '[') ||
                (bracket == '}' && stk.peek() == '{') ||
                (bracket == ')' && stk.peek() == '('))
            ) {
              stk.pop();
            } else {
                return false;
            }
        }

        return stk.isEmpty();
    }
}