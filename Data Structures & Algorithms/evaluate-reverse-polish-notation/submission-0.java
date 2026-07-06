class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            String t = tokens[i];

            if(isOpt(t)) {
                int opnd1 = Integer.parseInt(stack.pop());
                int opnd2 = Integer.parseInt(stack.pop());

                int result = 0;

                if(t.equals("+")) {
                    result = opnd2 + opnd1;
                } else if(t.equals("-")) {
                    result = opnd2 - opnd1;
                } else if(t.equals("*")) {
                    result = opnd1 * opnd2;
                } else {
                    result = opnd2 / opnd1;
                }

                stack.push(String.valueOf(result));
            } else {
                stack.push(t);
            }
        }


        return Integer.parseInt(stack.peek());
    }

    public boolean isOpt(String s) {
        return (s.equals("+") || s.equals("*") || s.equals("-") || s.equals("/"));
    }
}
