class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        return dfs(s, t, m, n, 0, 0, new HashMap<String, Integer>());
    }

    public int dfs(String s, String t, int m, int n, int i, int j, Map<String, Integer> map) {
        if(j == n) {
            return 1;
        }

        if(i == m) return 0;
        String key = i + ", " + j;
        if(map.containsKey(key)) {
            return map.get(key);
        }

        int res = 0;

        if(s.charAt(i) == t.charAt(j)) {
            res = dfs(s, t, m, n, i + 1, j + 1, map) + dfs(s, t, m, n, i + 1, j, map);
        } else {
            res = dfs(s, t, m, n, i + 1, j, map);
        }
        map.put(key, res);
        return res;
    }
}
