class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int change(int amount, int[] coins) {
        return helper(coins, amount, coins.length, 0);   
    }

    public int helper(int[] coins, int amount, int n, int idx) {
        if(idx == n) return 0;
        String key = amount + " " + idx;

        if(map.containsKey(key)) return map.get(key);
        if(amount < 0) return 0;
        if(amount == 0) return 1;

        int take = helper(coins, amount - coins[idx], n, idx);

        int dTake = helper(coins, amount, n, idx + 1);
        map.put(key, take + dTake);

        return take + dTake;

    }
}