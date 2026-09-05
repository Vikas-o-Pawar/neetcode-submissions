class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int k : nums) set.add(k);
        int res = 0;

        for(int k: set) {
            int f = 0;
            if(!set.contains(k - 1)) {
                while(set.contains(k)) {
                    f++;
                    k++;
                }
            }
            res = Math.max(res, f);
        }

        return res;
    }
}
