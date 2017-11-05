package LowFrequency;

public class Sqrt {
    /**
     * Easy O(F,B,Ap)
     */

    /**
     * Binary Search O(logn); O(1) Template
     * If x <= 1, return x.
     * Binary Search from 1 to x.
     * while start + 1 < end
     *   Calculate mid and compare mid with x / mid
     *   If mid = x / mid, square root found, return mid.
     *   If mid < x / mid, mid should be larger, start = mid.
     *   If mid > x / mid, mid should be smaller, end = mid.
     * return start. Here is a trick, because square root of integer should be rounded down.
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int start = 1;
        int end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
