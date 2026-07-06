class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];

            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String charSorted = new String(charArr);

            if(map.containsKey(charSorted)) {
                List<String> l = map.get(charSorted);
                l.add(str);
                map.put(charSorted, l);
            } else {
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(charSorted, l);
            }
        }

        return new ArrayList<>(map.values());
    }
}