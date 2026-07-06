class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        initMap(map);


        List<String> ls = new ArrayList<>();
        backtrack(digits, ls, map, new StringBuilder(), 0);

        return ls;
    }

    public void backtrack(String digits, List<String> ls, Map<Character, String> map, StringBuilder sb, int start) {
        if(start == digits.length()) {
            if(digits.length() > 0) ls.add(sb.toString());
            return;
        }

        String digitsStr = map.get(digits.charAt(start));

        for(int i = 0; i < digitsStr.length(); i++) {
            sb.append(digitsStr.charAt(i));
            backtrack(digits, ls, map, sb, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public void initMap(Map<Character, String> map) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}