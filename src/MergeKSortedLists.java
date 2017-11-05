import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    /**
     * Hard (Many)
     * follow up:
     * 1.interviewer说可以优化一下，如果PriorityQueue里面只剩一个list时候，可以直接merge不用在用PQ处理了
     * if (heap.size() == 0) { return dummy.next;}
     * 2.闻得很细：http://www.1point3acres.com/bbs/thread-206958-1-1.html
     * 3.传进来的parameter 是 List<Iterator>
     * 如果我用PriorityQueue的话 那是不是只要每次iterator.next()强制转换成ListNode然后其他的照常？
     * 是的，只是需要建立一个 Iterator 和 值的对应就好，每次 PriorityQueue poll 以后，知道从哪个iterator 去取
     */

    /**
     * Divide and Conquer O(nlogk);O(logk)
     * T(k) = 2T(k/2) + O(n*k)，空间复杂度的话是递归栈的大小O(logk)。http://blog.csdn.net/linhuanmars/article/details/19899259
     * Suppose we have k lists, merge k sorted lists can be divided.
     * 1) Merge the first k / 2 lists
     * 2) Merge k / 2 + 1 to k lists
     * Then just implement merging two lists.
     * Base cases:
     * 1) If start > end, return null;
     * 2) If start == end, there is only 1 list, return the head of that list;
     * 3) If start == end - 1, there are 2 lists, return the merged list.
     */

    /**
     * Let's assume k lists while each has n elements.
     * if we use a heap to extract the minimum element, it is quite obvious that we have O(n*k log k) complexity.
     * For the Divide & Conquer method,
     * 1st round: merge k/2 times, each with 2 * n times comparisons, total comparison is n * k ;
     * 2nd round: merge k/4 times, each with 4 * n times comparisons, total comparison is n * k;
     * ... there will be at most log k rounds ...
     * last round: merge 1 time, with 2^log k * n (=n * k) times comparison
     * <p>
     * Both time complexity will be O(nk *log k), now when one says there are N elements in total,
     * this N is actually the total number of elements in all the lists, resulting a time complexity of O(N log k).
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int s, int e) { //O(logk)
        if (s > e) {
            return null;
        }
        if (s == e) {
            return lists[s];
        }
        if (s + 1 == e) {
            return merge(lists[s], lists[e]);
        }
        return merge(divide(lists, s, s + (e - s) / 2),
                divide(lists, s + (e - s) / 2 + 1, e));
    }

    private ListNode merge(ListNode l1, ListNode l2) { //O(n)
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;

            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    /**
     * heap + dummy O(k + nlogk);O(k) k is lists'number, n is nodes' number.
     * Keep track of all heads in a min heap, so that we know the next value to be inserted in O(log(k)) time.
     * Create a min heap of ListNode.
     * Add all non-null heads to the heap.
     * Create a dummy head and a current pointer c from dummy.
     * While heap is not empty:
     * | Set c.next to the node get from heap top.
     * | Move c to c.next.
     * | Now c.next is the new head of that list.
     * | If c.next is not null, add it to heap.
     * Return dummy.next, which is the merged head.
     */
    public ListNode mergeKListsB(ListNode[] lists) {
        if (lists == null || lists.length == 0) { //corner case
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) { //corner case
                heap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!heap.isEmpty()) {
//            if (heap.size() == 1) {
//                cur.next = heap.poll();
//                return dummy.next;
//            }
            cur.next = heap.poll(); //O(logk)
            if (heap.size() == 0) { //a small optimization, save 7ms, total 23ms.
                return dummy.next;
            }
            cur = cur.next;
            if (cur.next != null) {
                heap.offer(cur.next); //O(logk)
            }
        }
        return dummy.next;
    }
}
