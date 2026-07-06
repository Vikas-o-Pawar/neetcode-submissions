class Solution {
public:
    int findMin(vector<int> &nums) {
        int left = 0, right = nums.size() - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            cout << left << right <<  mid << endl;

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                return nums[mid];
            }
        }

        return nums[left];
    }
};
