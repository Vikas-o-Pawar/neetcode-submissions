class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> q;

        for(auto n: nums) {
            q.push(n);
        }

        int i = 0;
        int res = 0;

        while(i < k) {
            res = q.top();
            q.pop();
            i++;
        }

        return res;
    }
};
