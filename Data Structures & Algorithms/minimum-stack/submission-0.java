class MinStack {

    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stk1.push(val);

        if(stk2.isEmpty()) {
            stk2.push(val);
        } else {
            if(stk2.peek() >= val) {
                stk2.push(val);
            }
        }
    }
    
    public void pop() {
        int p = stk1.pop();

        if(p == stk2.peek()) {
            stk2.pop();
        }
    }
    
    public int top() {
        return stk1.peek();
    }
    
    public int getMin() {
        return stk2.peek();
    }
}
