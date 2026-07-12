class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;

        for(int[] it: intervals) {
            q.offer(it);
        }

        int[] prev = q.poll();

        while(!q.isEmpty()) {
            int[] polled = q.poll();

            if(prev[1] > polled[0]) {
                // overlaps 
                // keep the smaller interval
                // as it gives more room for future intervals
                if(polled[1] <= prev[1]) {
                    prev = polled;
                }
                res++;
            } else {
                prev = polled;
            }
        }


        return res;
    }
}