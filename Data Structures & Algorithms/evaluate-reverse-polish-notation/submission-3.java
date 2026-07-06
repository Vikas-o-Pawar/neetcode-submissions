class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            int op1;
            int op2;

            if(token.equals("+")) {
                op1 = stk.pop();
                op2 = stk.pop();
                
                stk.push(op1 + op2);
            } else if(token.equals("-")) {
                op1 = stk.pop();
                op2 = stk.pop();

                stk.push(op2 - op1);
            } else if(token.equals("*")) {
                op1 = stk.pop();
                op2 = stk.pop();

                stk.push(op1 * op2);
            } else if(token.equals("/")) {
                op1 = stk.pop();
                op2 = stk.pop();

                stk.push(op2 / op1);
            } else {
                stk.push(Integer.parseInt(token));
            }
        }

        return stk.peek();
    }
}