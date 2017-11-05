import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContinuousSubarraySum {
    /**
     * Medium (F)
     * follow up:
     * 1.考虑negative number case. http://www.1point3acres.com/bbs/thread-276237-1-1.html
     * 我觉得下面解法已经可以解决存在负数的情况
     */

    /**
     * HashSet O(n);O(k)
     * There is really no need to use map, the required length is at least 2, so we just need to insert the mod one iteration later.
     * the original problem can be converted to find sum_i and sum_j, j - i >= 2 and sum_i % k == sum_j % k
     * the required length is at least 2, so we just need to insert the mod one iteration later.
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int preMod = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = k == 0 ? sum : sum % k;
            if (set.contains(mod)) {
                return true;
            }
            set.add(preMod);
            preMod = mod;
        }
        return false;
    }

    /**
     * HashMap O(n);O(k)
     * We iterate through the input array exactly once, keeping track of the running sum mod k of the elements in the process.
     * If we find that a running sum value at index j has been previously seen before in some earlier index i in the array,
     * then we know that the sub-array (i,j] contains a desired sum.
     */
    public boolean checkSubarraySumB(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            Integer prev = map.get(sum);
            if (prev != null) {
                if (i - prev > 1) return true;
            } else map.put(sum, i);
        }
        return false;
    }
/*    public boolean checkSubarraySum(int[] nums, int k) { //shit
        if (nums == null || nums.length < 2) {
            return false;
        }

        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i] == 0 && nums[i - 1] == 0) {
                    return true;
                }
            }
            return false;
        }

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == 0 && nums[i - 1] == 0) {
                return true;
            }

            sum += nums[i];
            if (sum % Math.abs(k) == 0 || set.contains(sum - k)) {
                return true;
            }

            if (!set.contains(sum)) {
                set.add(sum);
            }
        }
        return false;
    }*/
}
