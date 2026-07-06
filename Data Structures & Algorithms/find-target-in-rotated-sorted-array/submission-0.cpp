class Solution {
public:
    int search(vector<int>& nums, int target) {
        int minIdx = findMinIdx(nums);
        int size = nums.size();

        if(minIdx == 0) {
            return  binarySearch(nums, 0, size - 1, target);
        }

        int leftPart = binarySearch(nums, 0, minIdx - 1, target);

        if(leftPart != -1) {
            return leftPart;
        }

        int rightPart = binarySearch(nums, minIdx, size, target);
        return rightPart;
    }

    int binarySearch(vector<int> &nums, int l, int r, int target) {

        while(l <= r) {
            int m = (l + r) / 2;

            if(nums[m] < target) {
                l = m + 1;
            } else if(nums[m] > target) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    int findMinIdx(vector<int> & nums) {
        int l = 0, r = nums.size() - 1;

        while(l <= r) {
            int m = (l + r) / 2;

            if(nums[m] > nums[r]) {
                l = m + 1;
            } else if(nums[m] < nums[r]) {
                r = m;
            } else {
                return m;
            }
        }

        return l;
    }
};
