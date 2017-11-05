import java.util.*;

public class CloneGraph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
    /**
     * Medium (F,G,U)
     * follow up:
     * 1.Graph里面不一定所有node都相连，但是基本思路一样，被面试官指出了一个bug。。。希望不会影响听说最近bar高了
     */

    /**
     * BFS O(n + m);O(n)
     * Use map<Integer, UndirectedGraphNode> to represent the new graph and a visited set.
     * For each visit, connect the node with neighboring nodes.
     * If neighboring nodes not in new graph yet, need to create them.
     * Visit:
     * Check whether current label is in new graph:
     * | If not, create a new node with current label and put in map.
     * If neighbors exist:
     * | For each neighbor:
     * |   If its not visited, add it to queue and create a new node.
     * |   Connect current node with this neighbor.
     */
    public UndirectedGraphNode cloneGraphB(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    // copy nodes, store the old->new mapping information in HashMap
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor); //store visited neighbors
                }
                map.get(head.label).neighbors.add(map.get(neighbor.label)); //copy neighbors(edges)
            }
        }
        return clone;
    }

    /**
     * DFS
     * Statement: Given a node, and a graph map to build, return the cloned node.
     * Sub-problem: Build neighbors.
     * Complete task: Build current node. Build neighbors. Connect current node with its neighbors.
     * Base case: If current node is null, return null.
     * Implementation:
     * For each node in original node's neighbors:
     * | If new graph doesn't have it:
     * |   DFS to copy it and add returned copy node to clone's neighbor.
     * | If already have, means it's built:
     * |   Add it to clone's neighbor.
     * Return cloned node.
     */
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }
}
