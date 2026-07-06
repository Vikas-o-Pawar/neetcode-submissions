class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        vector<int> vec;
        priority_queue<pair<int, int>> pq;

        for(int i = 0; i < nums.size(); i++) {
            if(mp.find(nums[i]) == mp.end()) {
                mp[nums[i]] = 1;
            } else {
                mp[nums[i]] += 1;
            }
        }

        for(auto &m : mp) {
            pq.push({m.second, m.first});
        }

        for(int i = 0; i < k; i++) {
            pair<int, int> p = pq.top();
            pq.pop();
            vec.push_back(p.second);
        }


        return vec;
    }
};
