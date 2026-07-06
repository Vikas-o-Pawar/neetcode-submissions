class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int n = temperatures.length;
        int[] output = new int[n];

        for(int i = 0; i < n; i++) {
            int t = temperatures[i];

            while(!stk.isEmpty() && t > temperatures[stk.peek()]) {
                output[stk.peek()] = i - stk.peek();
                stk.pop();
            }

            stk.push(i);
        }

        return output;
    }
}
