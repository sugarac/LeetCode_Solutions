import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInAnArray {
    /**
     * Medium (Many)
     * follow up:
     * 1.Smallest
     * Quick Select: "nums.length - k" to k; minHeap: k -> nums.length - k + 1
     * 2.what if n is much greater than k. 比如n=1000000000， k=10
     * http://www.1point3acres.com/bbs/thread-209517-1-1.html
     * n个元素插入heap的复杂度是O(n), 用heap维护所有的n个，然后poll k次，这样时间复杂度是klogn
     * 3.先讨论了heap和quick select的解法和复杂度;实现了quickSelect的解法
     */

    /**
     * Quick Select O(n) average, O(n^2) worst;O(1) worst: choose the largest num as the pivot each time
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (k <= 0 || k > nums.length) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        int l = left, r = right;
        int pivot = nums[l + (r - l) / 2];
        while (l <= r) {
            while (l <= r && nums[l] > pivot) {
                l++;
            }
            while (l <= r && nums[r] < pivot) {
                r--;
            }
            if (l <= r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }

        if (left + k - 1 <= r) {
            return quickSelect(nums, left, r, k);
        }
        if (left + k - 1 >= l) {
            return quickSelect(nums, l, right, k - (l - left));
        }
        return nums[r + 1];
    }

    /**
     * minHeap O(nlogk);O(k)
     * Create a min heap as a window.
     * For each number in the array, add it to the heap.
     * If heap size > k, poll from the heap.
     * Return the top of the heap at the end.
     */
    public int findKthLargestB(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (k <= 0 || k > nums.length) {
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) { //每次弹出最小的，最后剩下k个数就是最大的k个数
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
//        shuffle(nums); //not necessary
//        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    /*        private int quickSelect(int[] nums, int l, int r, int k) {
            if (l == r) {
                return nums[l];
            }

            int pos = partition(nums, l, r);
            if (pos == k) {
                return nums[pos];
            } else if (pos < k) {
                return quickSelect(nums, pos + 1, r, k); //tail recursion
            } else {
                return quickSelect(nums, l, pos - 1, k); //tail recursion
            }
        }*/
/*    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }*/

    //    private void shuffle(int[] nums) {
//        Random random = new Random();
//        for (int i = 0; i < nums.length; i++) {
//            int rand = random.nextInt(i + 1);
//            swap(nums, i, rand);
//        }
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
}
