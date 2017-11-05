package LowFrequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CombinationSumIV {
    /**
     * Medium (F,G,S)
     * follow up:
     * 1.去重, 实际上就是Combination Sum I 计数版
     */

    /**
     * DP O(target * n);O(target)
     * dp[i] means the # of combinations that can reach sum i.
     * dp[i] = sum(dp[i - nums[j]]), where 0 <= j < nums.length, and nums[j] <= target.
     * dp[0] = 1. Think about [1], 1, where dp[1] = dp[1 - 1] = dp[0] = 1. just for recurrence calculation
     */
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num]; //Combination Sum I的“结果可重复”计数版
                }
            }
        }
        return dp[target];
    }

    /**
     * follow up 1.去重, 实际上就是Combination Sum I 计数版
     * DP O(target * n);O(target)
     * dp[i] = sum(dp[i - nums[j]]), where 0 <= j < nums.length, and nums[j] <= i <= target.
     */
    public static int combinationSum4D(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = num; i <= target; i++) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
//    What if negative numbers are allowed in the given array?
//    Then adding a num to the combination is not guaranteed to be increasing, which means I can add a huge bounch of negative nums
//    and add a huge bounch of positive nums to achieve a target sum.
//            eg.target=0:[-1,1],[-1,-1,1,1],[-1,-1,-1,1,1,1]...
//
//    How does it change the problem?
//    We will have lots of lots of possible combinations, even infinity.
//
//    What limitation we need to add to the question to allow negative numbers?
//    For example, each negative num can only be used once, etc.

    //sort + DP, not recommended
    public int combinationSum4B(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                } else {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int combinationSum4C(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length == 0 || target < 0) return 0;
        if (target == 0) return 1;
        if (map.containsKey(target)) return map.get(target);
        for (int num : nums) {
            count += combinationSum4C(nums, target - num);
        }
        map.put(target, count);
        return count;
    }
}
