class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();

        if(n < 2) {
            return 0;
        }

        int i = 0;
        int j = n - 1;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        int area = 0;

        while(i < j) {
            if(rightMax <= leftMax) {
                j--;
                area = area + max(0, rightMax - height[j]);
                rightMax = max(rightMax, height[j]);
            } else {
                i++;
                area = area + max(0, leftMax - height[i]);
                leftMax = max(leftMax, height[i]);
            }
        }

        return area;
    }
};
