import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumSizeSubarraySumEqualsk {
    /**
     * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one,
     * return 0 instead.
     * Note:
     * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
     * Example 1:
     * Given nums = [1, -1, 5, -2, 3], k = 3,
     * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
     * Example 2:
     * Given nums = [-2, -1, 2, 1], k = 1,
     * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
     * Follow Up: Can you do it in O(n) time?
     */

    /**
     * Medium (F,Pa) 考简化版
     * 1.只需要判断是否存在，返回boolean，用一个set做就可以，我一上来傻乎乎的写了map。。
     * 2.1，2，3，4，5 维持当前和1,3,6,10,15, 如果当前和为k或者当前和减去之前的一个和为k，则返回true。。。
     */

    /**
     * 简化版 if array exists Subarray Sum Equals k
     * HashSet O(n);O(n)
     * 如果只有非负数，可以用LC 209 Minimum Size Subarray Sum的双指针方法做，空间是O(1).
     */
    public boolean subarraySum(int[] nums, int k) {
        if (nums == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k || set.contains(sum - k)) {
                return true;
            }

            if (!set.contains(sum)) {
                set.add(sum);
            }
        }
        return false;
    }

    /**
     * HashMap O(n);O(n)
     */
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // start from sum = 0, where is a virtual index of -1.
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
//            if (sum == k) { //can be replaced by map.put(0, -1)
//                max = i + 1;
//            } else
            if (map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return res;
    }
}
