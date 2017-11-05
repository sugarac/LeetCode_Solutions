public class MergeTwoSortedArray {
    /**
     * Easy (F,M,B)
     * follow up:
     * 1.merge k sorted arrays
     */

    /**
     * 同向Two Pointers O(n + m);O(1)
     * One pointer i at the end of nums1. Another pointer j at the end of nums2.
     * Compare their values and put the larger one at the end of nums1.
     * The index is m+n-1. If m == 0, nums1 is fully merged, merge the rest of nums2.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (n > 0) {
            nums1[m + n - 1] = (m == 0 || nums1[m - 1] < nums2[n - 1]) ? nums2[--n] : nums1[--m];
        }
    }

    public void mergeB(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
