class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int n = queries.length;

        int[][] sortedQueries = new int[n][2];

        for(int i = 0; i < n; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        int[] res = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        for(int[] q: sortedQueries) {
            int query = q[0];
            int idx = q[1];

            while(i < intervals.length && intervals[i][0] <= query) {
                pq.offer(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < query) {
                // INTERVALS LEFT OF QUERY
                pq.poll(); 
            }

            res[idx] = pq.isEmpty()? -1: pq.peek()[0];
        }

        return res;
    }
}