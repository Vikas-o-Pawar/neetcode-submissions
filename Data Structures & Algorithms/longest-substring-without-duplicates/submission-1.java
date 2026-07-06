class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();


        int i = 0;
        int j = 0;
        int dist = 0;

        while(j < s.length()) {
            char ch = s.charAt(j);

            while(set.contains(ch)) {
                set.remove(s.charAt(i));
                i++;
            };

            set.add(ch);
            dist = Math.max(dist, j - i + 1);
            j++;
        }

        return dist;
    }
}
