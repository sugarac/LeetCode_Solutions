public class SearchInRotatedSortedArray {
    /**
     * Medium (F,L,U,M,B)
     * The template of Binary Search is very useful for this problem. Highly-ranked solution in LeetCode is also used this method.
     * Binary Search O(logn), O(1)
     * Use 2 pointers from both left and right to find the target.
     The condition of while-loop is start + 1 < end
       Calculate the mid index.
       If nums’ mid == target, return mid.
     If nums’ mid > nums’ start (left)
     If target is between nums’ start and mid, end = mid. Otherwise, start = mid.
     Otherwise,
     If target is between nums’ mid and end, start = mid. Otherwise, end = mid.
     Check if there is a number in the rest two numbers that is equal to target.
     If yes, return the corresponding index. Otherwise, return -1.
     * <p>
     * follow up:
     * LC 81.Search in Rotated Sorted Array II
     * This problem is used to inspect if we can find the worst case, which is O(n).
     * So we can just traverse the array to find the target.
     * !!!But we can still use Binary Search to solve this problem.
     * <p>
     * (Y) 如果给的数组可能是ascending order， 也可能是 descending order ，问应该怎么做
     * http://www.1point3acres.com/bbs/thread-220409-1-1.html
     * <p>
     * (A) 再follow up是[9, 8, 7, 1, 2, 3, 4] binary search. 这个和Search in Rotated Sorted Array不太一样，这里是先递减后递增
     * http://www.1point3acres.com/bbs/thread-160105-1-1.html (全二分的题目，很经典的面试）
     * http://blog.csdn.net/linhuanmars/article/details/20588511
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[start]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
