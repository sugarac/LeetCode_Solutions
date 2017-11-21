package Other;

public class BitwiseAndOfNumbersRange {
    /**
     * Solution1: O(logn); O(1)
     * In one word, this problem is asking us to find the common prefix of m and n 's binary code.
     * Shift m and n right by 1 bit until they are equal and use a variable record the reduced multiple.
     * Return multiply m by the multiple.
     */
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }

        int multiple = 1;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            multiple <<= 1;
        }
        return m * multiple;
    }
}
