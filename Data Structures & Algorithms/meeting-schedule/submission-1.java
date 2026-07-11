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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        if(intervals.size() == 0) return true;

        Interval prev = intervals.get(0);

        for(int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            if(interval.start < prev.end) {
                return false;
            } else {
                prev = interval;
            }
        }

        return true;
    }
}
