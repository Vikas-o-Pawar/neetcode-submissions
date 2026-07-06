class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for(int i : prices) {
            min = Math.min(min, i);
            profit = Math.max(profit, i - min);
        }

        return profit;
    }
}
