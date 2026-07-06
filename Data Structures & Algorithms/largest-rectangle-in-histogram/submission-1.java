class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stk = new Stack<>();
        int area = 0;

        for(int i = 0; i <= n; i++) {
            int ht = (i == n) ? 0: heights[i];

            while(!stk.isEmpty() && heights[stk.peek()] > ht) {
                int height = heights[stk.pop()];
                int width = stk.isEmpty() ? i: i - stk.peek() - 1;

                area = Math.max(area, width * height);
            }

            stk.push(i);
        }

        return area;
    }
}