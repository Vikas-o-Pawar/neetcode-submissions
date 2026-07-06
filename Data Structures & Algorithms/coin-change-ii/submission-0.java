class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Map<String, Integer> map = new HashMap<>();
        return helper(coins, amount, 0, n, map);
    }

    public int helper(int[] coins, int amount, int i, int n, Map<String, Integer> map) {
        if(amount < 0 || i == n) {
            return 0;
        }


        if(amount == 0) {
            return 1;
        }

        String key = i + ", " + amount;

        if(map.containsKey(key)) return map.get(key);

        int pick = helper(coins, amount - coins[i], i, n, map);
        int dontPick = helper(coins, amount, i + 1, n, map);
        map.put(key, pick + dontPick);
        
        return map.get(key);
    }
}