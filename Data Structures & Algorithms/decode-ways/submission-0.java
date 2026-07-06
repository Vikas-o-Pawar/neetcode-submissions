class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        return helper(s, 0, map);
    }

    public int helper(String s, int i, Map<Integer, Integer> map) {
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;

        if(map.containsKey(map)) return map.get(i);

        int ways = helper(s, i + 1, map);

        if(i + 1 < s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
            ways += helper(s, i + 2, map);
        }

        map.put(i, ways);
        return map.get(i);
    }
}
