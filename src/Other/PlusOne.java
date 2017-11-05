package Other;

public class PlusOne {
    /**
     * Solution1: Math O(n); O(n)
     * Traverse array from right to left. If current digit < 9, current digit adds one and return.
     * Otherwise set current digit to 0 and check next digit.
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNum = new int[n + 1];
        newNum[0] = 1;
        return newNum;
    }
}
