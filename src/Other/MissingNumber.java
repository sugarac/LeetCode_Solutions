package Other;

public class MissingNumber {
    /**
     * Bit Manipulation O(n); O(1)
     * Use XOR operation, since a^b^b =a, which means two XOR operations with the same number will eliminate the number and reveal the original number.
     * Use XOR operation to both the index and value of the array. In a complete array with no missing numbers,
     * the index and value should be perfectly corresponding (nums[index] = index),
     * so in a missing array, what left finally is the missing number.
     */
    public int missingNumber(int[] nums) {
        int xor = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor ^ i;
    }
//    public int missingNumber(int[] nums) {
//        Arrays.sort(nums);
//        int i = 0;
//        for (; i < nums.length; i++) {
//            if (nums[i] == i) {
//                continue;
//            }
//            return i;
//        }
//        return i;
//    }
}
