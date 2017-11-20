package Other;

public class FactorialTrailingZeroes {
    /**
     * Solution1: Iterative O(logn); O(1)
     * The 0 comes from 10. The 10 comes from 2 x 5.
     * In the n! operation, factor 2 is always ample. So we just count how many 5 factors in all numbers from 1 to n.
     */
    public int trailingZeroesB(int n) {
        int res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }

    /**
     * Solution2: Recursive O(logn); O(logn)
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
