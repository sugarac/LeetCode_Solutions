import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
    /**
     * BFS O(V + E);O(V)
     * 1.Convert graph presentation from edges to indegree of adjacent list.
     * 2.Add the course with 0 in-degree, which means no prerequisites to the order and queue.
     * 3.While queue is not empty:
     * | The head node dequeue
     * | Then remove it from the graph by reducing the in-degree of its adjacent nodes.
     * | If adjacent node's in-degree becomes 0, add it to the order and queue.
     * Finally, check whether all nodes are visited.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return null;
        }

        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        int index = 0;
        //1.Convert graph presentation from edges to indegree of adjacent list.
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }
        //2.Add the course which has no prerequisites to the order.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                order[index++] = i;
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == pre) {
                    int curCourse = prerequisites[i][0];
                    indegree[curCourse]--;
                    if (indegree[curCourse] == 0) {
                        order[index++] = curCourse;
                        queue.offer(curCourse);
                    }
                }
            }
        }
        return index == numCourses ? order : new int[0];
    }
}
