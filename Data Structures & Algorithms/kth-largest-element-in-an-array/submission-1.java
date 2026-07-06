class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        int i = 0;
        while(i < k) {
            q.offer(nums[i++]);
        }

        while(i < nums.length) {
            if(q.peek() < nums[i]) {
                q.poll();
                q.offer(nums[i]);
            }
            i++;
        }

        return q.peek();
    }
}