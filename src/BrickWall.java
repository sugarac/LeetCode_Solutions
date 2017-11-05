import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class BrickWall {
    /**
     * Medium (F) http://www.1point3acres.com/bbs/thread-268942-1-1.html
     * follow up:
     * 1.这面墙的高度很小，但是宽度很大，每一行可能有特别特别多的砖，问你怎么办。
     * 只需要有墙高度个数的pointer就可以了，比较当前指向的值有没有overlap，然后increment最小的那个
     */

    /**
     * HashMap O(nm);O(w) m is maximum of list.size(), w is width of wall
     * We want to cut from the edge of the most common location among all the levels,
     * hence using a map to record the locations and their corresponding occurrence
     * key是当前砖块的右边距离起点的距离，value是count
     */
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (List<Integer> list : wall) {
            int len = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                len += list.get(i);
                map.put(len, map.getOrDefault(len, 0) + 1);
                count = Math.max(count, map.get(len));
            }
        }
        return wall.size() - count;
    }

    /**
     * PriorityQueue 有时间学习下
     */
    public int leastBricksB(List<List<Integer>> wall) {
        int R = wall.size(), min = R;
        if (R == 1 && wall.get(0).size() > 1) return 0;
        // [0: end, 1: row, 2: col]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < R; i++) {
            pq.add(new int[]{wall.get(i).get(0), i, 0});
        }

        while (!pq.isEmpty()) {
            int end = pq.peek()[0], count = 0;
            while (!pq.isEmpty() && pq.peek()[0] == end) {
                count++;
                int[] brick = pq.poll();
                if (brick[2] < wall.get(brick[1]).size() - 1) {
                    pq.add(new int[]{end + wall.get(brick[1]).get(brick[2] + 1), brick[1], brick[2] + 1});
                }
            }
            if (!pq.isEmpty()) {
                min = Math.min(min, R - count);
            }
        }
        return min;
    }

    /**
     * follow up 1: 这面墙的高度很小，但是宽度很大，每一行可能有特别特别多的砖，问你怎么办。
     * 只需要有墙高度个数的pointer就可以了，比较当前指向的值有没有overlap，然后increment最小的那个
     */

}
