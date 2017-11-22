package Other;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    /**
     * Solution1: Topological Sort, BFS O(E + V); O(V)
     * Use an array to store each node’s indegree. Add all 0 indegree nodes to the queue.
     * During BFS, use a counter to record the number of visited nodes.
     * Each time poll a node from queue and decrease indegrees of all nodes it connects with.
     * If indegree becomes 0, add the node to queue.
     * When queue is empty, check if all nodes are visited, if yes, return true, otherwise false.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for (int[] p : prerequisites) {
            indegrees[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int[] p : prerequisites) {
                if (p[1] == course) {
                    indegrees[p[0]]--;
                    if (indegrees[p[0]] == 0) { //cannot put this if-block outside
                        queue.offer(p[0]);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
