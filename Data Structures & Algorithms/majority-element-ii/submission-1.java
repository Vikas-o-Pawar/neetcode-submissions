class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int i = 0;

        while(i < n) {
            int j = i + 1;

            while(j < n) {
                if(nums[i] == nums[j]) {
                    j++;
                } else {
                    break;
                }
            }

            int r = j - i;
            if(r > (n / 3)) {
                res.add(nums[i]);
            }
            i = j;
        }

        return res;
    }
}