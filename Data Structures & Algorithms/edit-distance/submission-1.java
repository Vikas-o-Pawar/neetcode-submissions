class Solution {
    public int minDistance(String word1, String word2) {
        Map<String, Integer> map = new HashMap<>();
        return dp(word1, word2, word1.length(), word2.length(), 0, 0, map);
    }

    public int dp(String w1, String w2, int m, int n, int i, int j, Map<String, Integer> map) {

        if(i == m) {
            return n - j;
        }

        if(j == n) {
            return m - i;
        }

        String key = i + ", " + j;
        int res = 0;
        if(map.containsKey(key)) return map.get(key);

        if(w1.charAt(i) == w2.charAt(j)) {
            res = dp(w1, w2, m, n, i + 1, j + 1, map);
        } else {
            int insert = dp(w1, w2, m, n, i, j + 1, map);
            int replace = dp(w1, w2, m, n, i + 1, j + 1, map);
            int delete = dp(w1, w2, m, n, i + 1, j, map);

            res = Math.min(insert, Math.min(replace, delete)) + 1;
        }

        map.put(key, res);
        return res;
    }
}
