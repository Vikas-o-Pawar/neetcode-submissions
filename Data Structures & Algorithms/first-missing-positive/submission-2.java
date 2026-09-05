class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length; 
        int[] a = new int[n + 1];
        int k = 0;

        for(int i = 0; i < n; i++) {
            int num = nums[i];
            if(num <= n && num >= 0) {
                a[num] = num;
            }
        }


        for(k = 1; k <= n; k++) {
            if(a[k] == 0) return k;
        }

        return k;
    }
}