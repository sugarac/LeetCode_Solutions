package Other;

public class SingleNumber {
    /**
     * Solution1: Bit Manipulation O(n); O(1)
     * We know that a ^ a = 0, 0 ^ a = a and the XOR operator is commutative,
     * so we can use ^ operation for all numbers to get the single number.
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
