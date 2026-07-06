class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, t = 0;

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), 
            Math.max(map.getOrDefault(s.charAt(i), Integer.MIN_VALUE), i)
            );
        }

        while(t < s.length()) {
            char c = s.charAt(t);
            r = Math.max(r, map.get(c));

            if(t == r) {
                res.add(r - l + 1);
                l = r + 1;
            }

            t++;
        }

        return res;        

    }
}
