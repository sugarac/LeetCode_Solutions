package Other;

public class ReverseBits {
    /**
     * Solution1: Iterative O(1); O(1)
     * Use a variable “res” to store the result.
     * During for loop, move res to left by 1 bit, use & to get last bit of n and add it to res by |.
     * Then move n to right by 1 bit.
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= n & 1;
            n >>= 1;
        }
        return res;
    }
}
