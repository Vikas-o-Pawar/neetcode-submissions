class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0;
        int min_p = INT_MAX;

        for(int p: prices) {
            min_p = min(min_p, p);
            profit = max(p - min_p, profit);
        }

        return profit;
    }
};
