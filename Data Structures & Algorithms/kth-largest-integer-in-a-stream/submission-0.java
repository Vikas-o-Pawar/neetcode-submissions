class KthLargest {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for(int n: nums) {
            if(q.size() == k && q.peek() < n) {
                q.poll();
                q.offer(n);
            }

            if(q.size() < k) {
                q.offer(n);
            }
        }    
    }
    
    public int add(int val) {
        if(q.size() < k) {
            q.offer(val);
            return q.peek();
        }

        if(val > q.peek() && q.size() == k) {
            q.poll();
            q.offer(val);
        }

        return q.peek();
    }
}
