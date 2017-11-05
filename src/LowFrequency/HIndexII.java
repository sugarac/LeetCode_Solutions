package LowFrequency;

public class HIndexII {
    /**
     * Think about the definition of h index: h papers that have >= h citations.
     * If randomly pick an index in the citations array, mid.
     * The # of papers have >= h citations is: array length - mid.
     * If citations[mid] = length - mid, return mid.
     * If citations[mid] > length - mid, paper not enough, mid should be smaller.
     * If citations[mid] < length - mid, too many papers, mid should be larger.
     */

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] >= n - mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return n - start;
    }
}
