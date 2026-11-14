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
        if (intervals == null ) {
            return false;
        }
        // sort by start time
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        // iterate throu the intervals
        for (int i = 1; i < intervals.size(); i++) {
            // if interval start is < prev end - false
            if (intervals.get(i).start < intervals.get(i-1).end) {
                return false;
            }
        }
        return true;
    }
}
