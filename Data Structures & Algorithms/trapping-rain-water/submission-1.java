class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int i = 0;
        int j = n - 1;

        int leftMax = height[i];
        int rightMax = height[j];
        int area = 0;

        while(i < j) {
            if(rightMax <= leftMax) {
                j--;
                area += Math.max(0, rightMax - height[j]);
                rightMax = Math.max(height[j], rightMax);
            } else {
                i++;
                area += Math.max(0, leftMax - height[i]);
                leftMax = Math.max(height[i], leftMax);
            }
        }

        return area;
    }
}
