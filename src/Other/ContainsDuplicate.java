package Other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    /**
     * Solution1: HashSet O(n); O(n)
     * Use HashSet to store each distinct number.
     * When adding a number to set returns false, which means duplicate, return true.
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Solution2: Sort O(nlogn); O(1)
     * Sort the array and then traverse the array to check if exists 2 neighboring numbers are same.
     */
    public boolean containsDuplicateB(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
