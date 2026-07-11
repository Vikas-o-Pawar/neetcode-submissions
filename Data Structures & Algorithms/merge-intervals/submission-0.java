class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();

        int i = 0; 
        int n = intervals.length;

        while(i < n) {
            int[] interval = intervals[i];

            int j = i + 1;
            if(j >= n) {
                res.add(interval);
                break;
            }

            int[] nextInterval = intervals[j];

            while(interval[1] < nextInterval[0]) {
                res.add(interval);
                i++;
                if(i >= n - 1) break;
                j = i + 1;
                interval = intervals[i];
                if(j >= n) {
                    res.add(interval);
                    break;
                }

                nextInterval = intervals[j];
            }

            boolean intervalFound = false;
            
            while(interval[1] >= nextInterval[0]) {
                intervalFound = true;
                interval[0] = Math.min(interval[0], nextInterval[0]);
                interval[1] = Math.max(interval[1], nextInterval[1]);
                j++;
                if(j >= n) break;
                nextInterval = intervals[j];
            }

            if(intervalFound) {
                res.add(interval);
                i = j;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}