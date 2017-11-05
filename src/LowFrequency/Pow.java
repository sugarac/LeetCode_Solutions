package LowFrequency;

public class Pow {
    /**
     * Medium
     */

    /**
     * Math O(logn); O(1)
     * Use a double-type variable to store the result and convert n to long-type to handle n = Integer.MIN_VALUE.
     * Calculate the absolute of n  first and in the end return corresponding value according to the sign of n.
     * Decompose the exponent into power of 2, so that we can keep dividing the problem in half.
     * N = 9 = 2^3 + 2^0 = 1001 in binary. Then: x^9 = x^(2^3) * x^(2^0).
     * Every time we encounter a 1 in the binary representation of N, multiply the result with x^(2^i).
     */
    public double myPow(double x, int n) {
        double res = 1;
        long N = Math.abs((long) n);
        while (N > 0) {
            if ((N & 1) == 1) {
                res *= x;
            }
            x *= x;
            N >>= 1;
        }
        return n < 0 ? 1 / res : res;
    }

    public double myPowB(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }
        if (n == Integer.MIN_VALUE) {
            return 0;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }

    public double myPow(double x, long n) { //把参数n的类型换成long就不需要考虑corner cases 或者 long N = (long) n;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }
}
