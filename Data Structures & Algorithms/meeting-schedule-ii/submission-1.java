/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for(int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            for(int j = i + 1; j < intervals.size(); j++) {
                Interval nextInterval = intervals.get(j);

                if(nextInterval.start >= interval.end) {
                    // conflict doesn't occur in this scenario
                    interval.end = Math.max(interval.end, nextInterval.end);
                    intervals.remove(j);
                    j--;
                }
            }
        }
        
        return intervals.size();
    }
}
