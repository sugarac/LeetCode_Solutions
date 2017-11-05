import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    /**
     * Hard (F,L,G)
     * follow up:
     * 1.do it in place http://www.1point3acres.com/bbs/thread-214602-1-1.html
     * solve
     */

    /**
     * Iterative O(n);O(1)
     * Create a result list of intervals, res.
     * Add new interval to res first.
     * Go through the given intervals.
     * For each interval i, there are 3 situations:
     * 1) i and previous interval not overlapping, in front of the new interval.
     * 2) No overlap, behind the new interval
     * 3) Overlap, merge with the new interval
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }

        //insert newInterval to intervals, which is different from skip non-overlapping intervals
        int i = 0;
        while (intervals.get(i) != null && intervals.get(i).start < newInterval.start) {
            i++;
        }
        intervals.add(i, newInterval);

        //merge intervals
        List<Interval> res = new ArrayList<>();
        Interval pre = null;
        for (Interval cur : intervals) {
            if (pre == null || pre.end < cur.start) {    //non-overlapping
                res.add(cur);
                pre = cur;
            } else {
                pre.end = Math.max(pre.end, cur.end);
            }
        }
        return res;
    }

    /**
     * Iterative & in place O(n);O(1)
     * Skip the non-overlapping intervals whose end time is before new interval's start.
     * For overlapped intervals that start before new interval end.
     * | Remove this overlapped interval from list.
     * | Merge it with the new interval by: 1. update start to min start times; 2. update end to max end times.
     * Add new interval in the position i.
     */
    public List<Interval> insertB(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }

        //skip non-overlapping intervals
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            i++;
        }

        //merge intervals in place
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            Interval overlap = intervals.remove(i);
            newInterval.start = Math.min(newInterval.start, overlap.start);
            newInterval.end = Math.max(newInterval.end, overlap.end);
        }
        intervals.add(i, newInterval);
        return intervals;
    }

    public List<Interval> insertC(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            return null;
        }

        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        Interval cur = newInterval;
        for (Interval inv : intervals) {
            if (inv.end < cur.start) { //inv to the left of cur
                result.add(inv);
            } else if (cur.end < inv.start) { //inv to the right of cur
                result.add(cur);
                cur = inv;
            } else {//overlap
                cur.start = Math.min(cur.start, inv.start);
                cur.end = Math.max(cur.end, inv.end);
            }
        }
        result.add(cur);
        return result;
    }
}
