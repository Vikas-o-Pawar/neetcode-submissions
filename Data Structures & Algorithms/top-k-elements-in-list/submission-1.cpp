class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        int arr[2002] = {0};
        vector<int> vec;

        for(int &n: nums) {
            int idx = n + 1000;
            arr[idx]++;
        }

        for(int i = 0 ; i < k; i++) {
            int maxIdx = findMax(arr) - 1000;
            vec.push_back(maxIdx);
        }

        return vec;
    }


public:
    int findMax(int arr[]) {
        int max = 0;

        for(int i = 0; i <= 2001; i++) {
            if(arr[i] > arr[max]) {
                max = i;
            }
        }
        arr[max] = 0;

        return max;
    }

};
