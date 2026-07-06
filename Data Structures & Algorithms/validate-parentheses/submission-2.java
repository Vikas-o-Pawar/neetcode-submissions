class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean isEmpty = stack.isEmpty();

            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }else if(!isEmpty && ch == ')' && stack.peek() == '(') {
                stack.pop();
            } else if(!isEmpty && ch == ']' && stack.peek() == '[') {
                stack.pop();
            } else if(!isEmpty && ch == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        if(stack.isEmpty()) {
            return true;
        }

        return false;
    }
}
