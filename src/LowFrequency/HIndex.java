package LowFrequency;

public class HIndex {
    /**
     * Medium (F,G,B)
     * follow up:
     * 1.换种问法，如下：
     * Given一个unsorted array， find the greatest natural number N, such that,
     * there exists at least N numbers in the array which are greater or equal to N 比如input是【5，5，5】的话，output是3
     */

    /**
     * Bucket Sort O(n);O(1)
     * Suppose n is the number of papers.
     * H can be at most n when a person has n papers and all of them have more than n citations.
     * To find a number h that h of his n papers have >= h citations, put papers in buckets.
     * All papers have >= n citations put into bucket n.
     * Papers have i citations put into bucket i.
     * Then count backwards.
     * The first number i that has total papers >= i is the answer.
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }

        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
