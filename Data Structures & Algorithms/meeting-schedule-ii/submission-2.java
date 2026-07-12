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
        List<Integer> s = new ArrayList<>();
        List<Integer> e = new ArrayList<>();

        for(Interval it: intervals) {
            s.add(it.start);
            e.add(it.end);
        }

        Collections.sort(s);
        Collections.sort(e);
        
        int count = 0;
        int res = 0;

        int i = 0;
        int j = 0;

        while(i < intervals.size() && j < intervals.size()) {
            int st = s.get(i);
            int ed = e.get(j);

            if(st < ed) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }

            res = Math.max(count, res);
        }

        return res;
    }
}
