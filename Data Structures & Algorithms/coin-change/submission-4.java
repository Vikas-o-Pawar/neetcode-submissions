class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<String, Integer> map = new HashMap<>();
        int n = coins.length;
        int r = helper(coins, amount, 0, map, n);
        return r == Integer.MAX_VALUE - 1? -1 : r;
    }

    public int helper(int[] coins, int amount, int i, Map<String, Integer> map, int n) {
        if(amount == 0) {
            return 0;
        }


        if(amount < 0 || i == n) {
            return Integer.MAX_VALUE - 1;
        }

        String key = i + ", " + amount;

        if(map.containsKey(key)) return map.get(key);

        int pick = 1 + helper(coins, amount - coins[i], i, map, n);
        int dontPick = helper(coins, amount, i + 1, map, n);


        int res = Math.min(pick, dontPick);
        map.put(key, res);
        return map.get(key);
    }
}
