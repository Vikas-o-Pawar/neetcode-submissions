class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int len = 0;

        for(int n: nums) {
            set.add(n);
        }

        for(int n : nums) {
            int l = 0;
            
            if(!set.contains(n - 1)) {
                // we're at the beginning of the sequence

                while(set.contains(n)) {
                    l++;
                    n++;
                }
            }

            len = Math.max(l, len);
        }


        return len;
    }
}
