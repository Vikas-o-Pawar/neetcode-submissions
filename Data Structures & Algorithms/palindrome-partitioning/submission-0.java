class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), s, s.length(), 0);
        return res;
    }

    public void helper(List<List<String>> res, List<String> ls, String s, int n, int start) {
        if(start == n) {
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int i = start; i < n; i++) {
            if(isPal(s, start, i)) {
                ls.add(s.substring(start, i + 1));
                helper(res, ls, s, n, i + 1);
                ls.removeLast();
            }
        }
    }

    public boolean isPal(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++; 
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}