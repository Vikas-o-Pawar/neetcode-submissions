class Solution {
public:
    int maxArea(vector<int>& heights) {
        int maxContainer = 0;
        int i = 0;
        int j = heights.size() - 1;

        while(i < j) {
            int length = std::min(heights[i], heights[j]); 
            int breadth = j - i;

            maxContainer = std::max(length * breadth, maxContainer);

            if(heights[i] > heights[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxContainer;
    }
};