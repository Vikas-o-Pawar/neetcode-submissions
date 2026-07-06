class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        permuteHelper(nums, 0, result);

        return result;
    }

    public void permuteHelper(int[] nums, int index, List<List<Integer>> result) {
        if(index == nums.length) {
            List<Integer> ls = new ArrayList<>();
            for(int n : nums) {
                ls.add(n);
            }

            result.add(ls);
            return;
        }

        for(int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permuteHelper(nums, index + 1, result);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
