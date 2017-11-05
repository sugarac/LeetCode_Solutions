import java.util.*;

public class MergeInterval {
    /**
     * Medium (F,L,G,T,M,Y,B)
     * follow up:
     * 1.先给了个in place的做法，follow up换成输出一个new list
     * 不推荐用in place做法
     * 2.上来给一串start time － end time，格式是Apr 2010 － Mar 2011这种，要求计算出这些时间的总跨度，重叠的跨度不重复计算。
     * 举例：["Apr 2010 - Dec 2010", "Aug 2010 - Dec 2010", "Jan 2011 - Mar 2011"]这一个string数组，结果为（12-4+3-1）＝10个月。
     */

    /**
     * Iterative O(nlogn);O(1)
     * Sort the intervals in ascending order of start time.
     * Use a pointer, pre, to record previous merged interval.
     * For each interval:
     * | If pre is null(empty) or pre.end < cur.start (no overlap), add directly and update pre.
     * | Otherwise, merge previous and current intervals.
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null) {
            return res;
        }

        intervals.sort((a, b) -> a.start - b.start);

        Interval pre = null;   //last is the copy of the last element in the res. easy to understand
        for (Interval cur : intervals) {
            if (pre == null || pre.end < cur.start) {
                res.add(cur);
                pre = cur;
            } else {
                pre.end = Math.max(pre.end, cur.end);
            }
        }
        return res;
    }

    /**
     * input is unsorted and has some overlapping intervals, output is the total non-overlapping time; O(nlogn) time, O(1) space
     */
    public int totalTime(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);

        //you can also merge intervals before calculating,which makes calculation easier,but takes some memory(new arraylist)
        int total = 0;
        Interval pre = new Interval(0, 0);
        for (Interval cur : intervals) {
            if (pre.end < cur.start) {
                total += cur.end - cur.start;//add the whole part(non-overlapping)
            } else if (cur.end > pre.end) {
                total += cur.end - pre.end;//only add the non overlapping part after prev.end
            }//else curr.end<=prev.end(curr inside prev),don't calculate anything,and prev isn't updated(prev.end is bigger)
            pre = cur;
        }
        return total;
    }

    public List<Interval> mergeB(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

//        Collections.sort(intervals, new Comparator<Interval>() {
//            public int compare(Interval a, Interval b) {
//                return a.start - b.start;
//            }
//        });
//        Collections.sort(intervals, (a, b) -> a.start - b.start);
//        Collections.sort(intervals, Comparator.comparing()); //don't know how to write
        intervals.sort((a, b) -> a.start - b.start);

        List<Interval> res = new ArrayList<>();
        Interval last = intervals.get(0);   //last is the copy of the first wiil-be-put-in-res element. faster
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start > last.end) {
                res.add(last);
                last = cur;
            } else {
                last.end = Math.max(last.end, cur.end);
            }
        }
        res.add(last);
        return res;
    }

    /**
     * Sort start & end respectively.
     * this approach is faster than just by sorting the start time itself.
     * I think sorting the primary type is faster than the reference type.
     */
    public List<Interval> mergeC(List<Interval> intervals) {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }
}
