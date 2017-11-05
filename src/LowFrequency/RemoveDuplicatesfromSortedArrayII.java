package LowFrequency;

public class RemoveDuplicatesfromSortedArrayII {
    /**
     * Medium (F)
     */

    /**
     * Template 同向Two Pointers O(n);O(1)
     * Duplicates are allowed at most twice.
     * It means that the number can be the same as the last number.
     * Instead of comparing with the last number, compare with the second last.
     * Implementation:
     * Edge case: If nums.length <= 2, already true, return nums.length.
     * For each number n in nums:
     * | If len < 2 or n > nums[len - 2]:
     * |   Set nums[len] to n. Add len by 1.
     * Return len.
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int len = 0;
        for (int num : nums) {
            if (len < 2|| num > nums[len - 2]) {
                nums[len++] = num;
            }
        }
        return len;
    }
}
