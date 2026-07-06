class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        this.left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        this.right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.isEmpty()) {
            left.offer(num);
            return;
        } else if(right.isEmpty()) {
            if(left.peek() <= num) {
                right.offer(num);
                // [2] [] -> put in right (eg num = 5)
            } else {
                right.offer(left.poll());
                left.offer(num);
                // [2] [] -> put in left (eg num = 1);
            }
        } else if(num >= left.peek() && num < right.peek()) {
            left.offer(num);
            // [2] [5] -> put in left (eg num = 3);
        } else if(num > left.peek()) {
            right.offer(num);
            // [1,3] [45] -> put in right (eg num = 5) 
            // can't put in left then
        } else {
            left.offer(num);
        }

        // balance the queues
        if((Math.abs(left.size() - right.size()) >= 2) ||
            (Math.abs(right.size() - left.size()) >= 2)) {
            if(left.size() > right.size()) {
                right.offer(left.poll());
            } else {
                left.offer(right.poll());
            }
        } 
    }
    
    public double findMedian() {
        int size = left.size() + right.size();       

        if(size % 2 != 0) {
            // odd
            if(left.size() > right.size()) {
                return (double) left.peek();
            } else {
                return (double) right.peek();
            }
        } else {
            return (double) (left.peek() + right.peek()) / 2;
        }   
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */