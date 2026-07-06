class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();

        int i = 0;
        int j = 0;
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;

        while(j < n) {

            int num = nums[j];

            while(!dq.isEmpty() && nums[dq.peekLast()] < num) {
                dq.pollLast();
            }

            dq.offerLast(j);
            j++;

            if(j - i == k) {
                result[idx++] = nums[dq.peekFirst()];

                if(nums[i] == nums[dq.peekFirst()]) {
                    dq.pollFirst();
                }

                i++;
            }
        }

        return result;
    }
}
