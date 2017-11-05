import java.util.ArrayList;
import java.util.List;

public class MergeKSortedArrays {
    /**
     * http://www.lintcode.com/en/problem/merge-k-sorted-arrays/
     * Given k sorted integer arrays, merge them into one sorted array.
     * Example: Given 3 sorted arrays:
     * [
     * [1, 3, 5, 7],
     * [2, 4, 6],
     * [0, 8, 9, 10, 11]
     * ]
     * return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
     * <p>
     * http://www.1point3acres.com/bbs/thread-145383-1-1.html
     * 1. int[][]
     * 2. binary merge 就是 [arr1, arr2, arr3, arr4], 先merge 1 2再merge 3 4，再merge上一轮的两个结果，
     * 然后时间是O((KL)logK) 假设L是平均长度， 因为外层数组长度只有K，所以递归的层数是logk层。
     * brute-force是全部丢进heap，这样时间是O((KL)log(KL))。空间O(k)还是有区别的
     */

    /**
     * Divide and Conquer + Binary Merge O(nlogk);O(logk)
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        List<Integer> res = new ArrayList<>();
        int[] newArray = divide(arrays, 0, arrays.length - 1);
        for (int i = 0; i < newArray.length; i++) {
            res.add(newArray[i]);
        }
        return res;
    }

    private int[] divide(int[][] arrays, int s, int e) { //O(logk)
        if (s == e) {
            return arrays[s];
        }
        return merge(divide(arrays, s, s + (e - s) / 2),
                divide(arrays, s + (e - s) / 2 + 1, e));
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] newArray = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            newArray[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < m) {
            newArray[k++] = nums1[i++];
        }
        while (j < n) {
            newArray[k++] = nums2[j++];
        }
        return newArray;
    }
}
