import java.util.*;

public class GraphValidTree {
    /**
     * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
     * write a function to check whether these edges make up a valid tree.
     * For example:
     * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
     * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
     * Hint:
     * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
     * According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are
     * connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
     * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same
     * as [1, 0] and thus will not appear together in edges.
     */

    /**
     * Medium (F,G)
     * follow up:
     * 1.不同的一点是, 这道题目是有向图, 而lc里面是无向图 http://www.1point3acres.com/bbs/thread-180011-1-1.html
     */

    /**
     * BFS O(V + E);O(V)
     * 1.create an adjacency list of the undirected graph
     * 2.use an array to record if the vertex is visited and record the vertex "0" as visited by assigning 1
     * 3.use queue to store visited vertexes and add the vertex "0" to queue
     * 4.visit each vertex's successors
     * if successor is recorded by 1, which means existing a cycle, return false
     * if successor is recorded by 0, add the successor to queue and record the successor as visited
     * after visit all successors of one vertex, record the vertex by 2
     * 5.check the array "visited", if it exists "0", which means existing unconnected vertex, return false
     */
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0 || edges.length != n - 1) {
            return false;
        }

        //create an adjacency list of the undirected graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int[] visited = new int[n]; //use an array to record if the vertex is visited
        visited[0] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (Integer succ : adjList.get(cur)) {
                if (visited[succ] == 1) { // exist a cycle
                    return false;
                }
                if (visited[succ] == 0) {
                    queue.offer(succ);
                    visited[succ] = 1;
                }
            }
            visited[cur] = 2; //complete the successor's visit of one vertex
        }
        for (int v : visited) {
            if (v == 0) { // exist an unconnected vertex
                return false;
            }
        }
        return true;
    }

    /**
     * Union Find
     * Quick check: It requires n-1 edges to connect n vertices. So if edges.length != n-1, return false.
     * Initialize an array of connected component ids.
     * For each edge in edges:
     * | Find the connected component ids for the two nodes.
     * | If the ids are the same, the two nodes are already connected, return false.
     * | Else, union the two nodes by set x's id to y.
     * After checking all edges, return tru
     */
//    public boolean validTreeB(int n, int[][] edges) {
//        // initialize n isolated islands
//        int[] nums = new int[n];
//        Arrays.fill(nums, -1);
//
//        // perform union find
//        for (int i = 0; i < edges.length; i++) {
//            int x = find(nums, edges[i][0]);
//            int y = find(nums, edges[i][1]);
//
//            // if two vertices happen to be in the same set
//            // then there's a cycle
//            if (x == y) return false;
//
//            // union
//            nums[x] = y;
//        }
//
//        return edges.length == n - 1;
//    }
//
//    int find(int nums[], int i) {
//        if (nums[i] == -1) return i;
//        return find(nums, nums[i]);
//    }
    public boolean validTreeC(int n, int[][] edges) {
        // Quick check on the number of edges. It requires n - 1 edges to connect n vertices.
        if (edges.length != n - 1) {
            return false;
        }
        // Init cc id array.
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        // Check cycle.
        for (int i = 0; i < edges.length; i++) {
            // Find connected component ids of the two nodes.
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            if (x == y) { // If two vertices are already connected.
                return false;
            }
            // Union
            nums[x] = y; // Add edges[i][0] to the connected component.
        }
        return true;
    }

    /**
     * Recursive.
     * Find connected component id, or the root id.
     * Check whether child(current index) and parent(the value) are the same.
     * If they are, return the index.
     * If not, set index to the value and check again.
     * Stop till we find the root.
     */
    private int find(int nums[], int i) {
        while (i != nums[i]) {
            // Here if we found the child's id are not the same as the parent's.
            // We know the parent can be an intermediate id.
            // So we set parent's id to grand parent's id.
            // Which will dynamically balance the tree thus reducing O(n) to O(1).
            nums[i] = nums[nums[i]];
            i = nums[i];
        }
        return i;
    }
    /**
     * DFS
     */

}
