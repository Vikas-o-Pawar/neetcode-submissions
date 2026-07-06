class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        return climbStairs(n, map);        
    }

    public int climbStairs(int n, HashMap<Integer, Integer> map) {
        if(map.containsKey(n)) {
            return map.get(n);
        }
        
        if(n == -1) {
            return 0;
        }


        if(n == 0) {
            return 1;
        }

        int oneStep = climbStairs(n - 1, map);
        int twoStep = climbStairs(n - 2, map);

        map.put(n, oneStep + twoStep);

        return map.get(n);
    }
}