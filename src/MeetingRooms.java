import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine
     * if a person could attend all meetings.
     * For example,
     * Given [[0, 30],[5, 10],[15, 20]],
     * return false.
     */

    /**
     * Easy (F)
     * Sort intervals by start time. O(n);O(1)
     * From second interval, check each interval with the previous one.
     * If current interval's start < previous interval's end, return false.
     */
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }

//        Arrays.sort(intervals, new Comparator<Interval>() {
//            public int compare(Interval a, Interval b) {
//                return a.start - b.start;
//            }
//        });
        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }
}
