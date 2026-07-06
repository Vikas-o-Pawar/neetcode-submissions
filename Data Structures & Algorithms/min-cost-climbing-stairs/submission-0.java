class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = cost.length;

        int n1 = dp(cost, n - 1, map);
        int n2 = dp(cost, n - 2, map);

        return Math.min(n1, n2);
    }

    public int dp(int[] cost, int n, HashMap<Integer, Integer> map) {
        if(n <= 0) {
            return n == 0? cost[0] : 0;
        }

        if(map.containsKey(n)) {
            return map.get(n);
        }

        int n1 = dp(cost, n - 1, map);
        int n2 = dp(cost, n - 2, map);
        
        
        map.put(n, Math.min(n1 + cost[n], n2 + cost[n]));

        return map.get(n);
    }
}