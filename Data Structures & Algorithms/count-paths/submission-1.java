class Solution {
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> map = new HashMap<>();
        return uP(m - 1, n - 1, map);
    }

    public int uP(int m, int n, HashMap<String, Integer> map) {
        String key = m + "," + n;

        if(map.containsKey(key)) {
            return map.get(key);
        }

        if(m == 0 && n == 0) {
            return 1;
        }
        
        int up = 0, left = 0;

        // up
        if(m >= 0) {
            up = uP(m - 1, n, map);
        }

        // left
        if(n >= 0) {
            left = uP(m, n - 1, map);
        }

        map.put(key, up + left);
        return up + left;
    }
}