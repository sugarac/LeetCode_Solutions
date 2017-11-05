package LowFrequency;

public class RemoveDuplicatesfromSortedArray {
    /**
     * Easy (F,M,B)
     * follow up:
     * 1.Erase duplicate in an unsorted array
     * hash map和sort两种方法都可以 O(n);O(n), O(nlogn);O(1)
     */

    /**
     * Template 同向Two Pointers O(n);O(1)
     * Use the length to be returned as a pointer to the next position to be filled.
     * For each number n in nums:
     * | If length is 0 or n > nums[length - 1]:
     * |   Update nums[length] to n. Increment length by 1.
     * Return length.
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int len = 0;
        for (int num : nums) {
            if (len < 1 || num > nums[len -  1]) {
                nums[len++] = num;
            }
        }
        return len;
    }

    /**
     * Template can also be used in 27. Remove Element
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return -1;
        }

        int len = 0;
        for (int num : nums) {
            if (num != val) {
                nums[len++] = num;
            }
        }
        return len;
    }
}
