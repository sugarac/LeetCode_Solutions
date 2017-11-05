import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    /**
     * HashMap + Doubly LinkedList
     * Build a HashMap between Node’s key and Node, the size is capacity of LRU.
     * Create a dummy head and tail in Doubly LinkedList to mark the boundary, so that we don't need to check the NULL node during the update.
     * For operation get, get node from HashMap according to key and move node to head.
     * For operation put, if key exists in HashMap, update the value of node. Otherwise, create a new node and add it to HashMap and Doubly LinkedList. If the size of HashMap reaches its capacity, remove the last node.
     */
    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private void addNode(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node; //不能和下面的交换
        head.next = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    int capacity;
    Map<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            addNode(newNode);
            cache.put(key, newNode);
            if (cache.size() > capacity) {
                Node last = tail.pre;
                removeNode(last);
                cache.remove(last.key);
            }
        }
    }
}