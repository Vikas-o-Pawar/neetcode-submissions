class Solution {
    public int coinChange(int[] coins, int amount) {
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.sort(coins);

        int res = dp(coins, amount, 0, map);
        return res == 2147483646? -1: res;
    }

    public int dp(int[] coins, int amt, int n, Map<String, Integer> map) {
        if(amt == 0) {
            return 0;
        }

        String key = n + "," + amt;

        if(map.containsKey(key)) {
            return map.get(key);
        }

        if(amt < 0 || n == coins.length) {
            return Integer.MAX_VALUE - 1;
        }

        int take = 1 + dp(coins, amt - coins[n], n, map);
        int dontTake = dp(coins, amt, n + 1, map);

        int res = Math.min(take, dontTake);
        map.put(key, res);
        return res;
    }
}