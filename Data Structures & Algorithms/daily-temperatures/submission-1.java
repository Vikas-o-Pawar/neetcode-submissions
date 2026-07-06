class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]) {
                int popped = stk.pop();
                answer[popped] = i - popped;
            }

            stk.push(i);
        }

        return answer;
    }
}