package Other;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    /**
     * Solution1: Iterative O(n); O(1)
     * Traverse the array, if num > lower, add missing range to the result.
     * Then check if num = upper, if =, return result list, otherwise update lower to num + 1.
     * After traversing, check if lower <= upper, if yes, add missing range to result.
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for (int num : nums) {
            if (num > lower) {
                //use (num - 1 > lower), not (num - lower > 1) due to overflow
                res.add(lower + ((num - 1 > lower) ? "->" + (num - 1) : "")); //(num -1)
            }
            if (num == upper) { //check num, not lower
                return res;
            }
            lower = num + 1;
        }
        if (lower <= upper) {
            res.add(lower + (lower < upper ? "->" + upper : ""));
        }
        return res;
    }
}
