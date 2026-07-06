class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        int i = 0;
        int n = nums.length;

        while(i < n) {
            int j = i + 1;
            int k = n - 1;

            int curr = nums[i];

            while(j < k) {
                int sum = curr + nums[j] + nums[k];

                if(sum < 0) {
                    j++;
                } else if(sum > 0) {
                    k--;
                } else {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);

                    set.add(l);
                    j++;
                    k--;
                }
            }
            i++;
        }

        for(List<Integer> l: set) {
            ls.add(l);
        }

        return ls;
    }
}
