import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the
     * minimum number of conference rooms required.
     * For example,
     * Given [[0, 30],[5, 10],[15, 20]],
     * return 2.
     */

    /**
     * Medium (F,G)
     * follow up:
     * 1.然后问了meeting rooms II，简单和面试官说了一下思路，然后面试官告诉我不能用PriorityQueue做，
     * 只好现想答案，中间想到一个recurssion的但是也不行，最终用了两个arrays把start和end time分别找出来然后sort做的，面试官说good，然后就开始让我问问题，大概问了两三个问题后，结束面试。
     * 2.类似Meeting Rooms2，输出最大overlap的数量。跟原题不同的是，[3,5]和[5,5]这两个interval也算overlap，应该输出2，而不是1。
     * 所以只要把原题的intervals.start >= heap.peek()改成>就可以了。
     */

    /**
     * minHeap O(nlogn);O(n)
     * Always put the next starting meeting after the first ending meeting.
     * If the start time overlaps with the nearest end time, need a new room.
     * So, sort the meetings according to start time first.
     * Then for each interval in the array:
     * | If min heap is not empty and start time doesn't overlap with first ending time:
     * |   Poll first ending time from the heap.
     * | Add the ending time for current meeting.
     */
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

//        Arrays.sort(intervals, new Comparator<Interval>() {
//            public int compare(Interval a, Interval b) {
//                return a.start - b.start;
//            }
//        });
        Arrays.sort(intervals, (a, b) -> a.start - b.start);

    /*  PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });

        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval head = heap.poll();
            if (head.end <= intervals[i].start) {
                head.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
        }*/
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (Interval i : intervals) {
            if (!heap.isEmpty() && i.start >= heap.peek()) { //non-overlap, which means one room can be reused
                heap.poll();
            }
            heap.add(i.end);
        }
        return heap.size();
    }

    /**
     * two arrays O(nlogn);O(n)
     */
    public int minMeetingRoomsB(Interval[] intervals) {
        if (intervals == null || intervals.length == 1) {
            return 0;
        }

        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int reusedRooms = 0;
        for (int i = 0; i < n; i++) {
            if (start[i] < end[i]) {
                rooms++;
            } else {
                reusedRooms++;
            }
        }
        return rooms;
    }

    /**
     *返回最大房间数时时间 return the exact time that has max num of room used (any valid time)
     */
    public int minMeetingRoomsC(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        int overlapStart = -1;
        int overlapEnd = -1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (Interval i : intervals) {
            if (!heap.isEmpty() && i.start >= heap.peek()) { //non-overlap, which means one room can be reused
                heap.poll();
            } else {
                //代码应该有问题，等开会员后测试一下
                overlapStart = i.start;
                overlapEnd = Math.min(heap.peek(), i.end);//should be min of these two
            }
            heap.add(i.end);
        }
        return overlapStart;
    }
}
