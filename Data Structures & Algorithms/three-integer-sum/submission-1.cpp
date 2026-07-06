class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int i = 0;
        vector<vector<int>> vec;
        std::sort(nums.begin(), nums.end());
        std::set<std::vector<int>> st;

        while(i < nums.size()) {
            int j = i + 1;
            int k = nums.size() - 1;

            int curr = nums[i];

            while(j < k) {
                int sum = curr + nums[j] + nums[k]; 
                if(sum < 0) {
                    // increase the number;
                    j++;
                } else if(sum > 0) {
                    // decrease the number - will lead to decrease in the sum
                    k--;
                } 
                
                else {
                    vector<int> v;
                    v.push_back(nums[i]);
                    v.push_back(nums[j]);
                    v.push_back(nums[k]);
                    st.insert(v);

                    j++;
                    k--;
                }
            }

            i++;
        }

        for(auto s: st) {
            vec.push_back(s);
        }

        return vec;
    }
};
