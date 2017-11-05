package Subarray;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    /**
     * PreSum + HashMap O(n);O(1)
     * if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j].
     * To achieve this, we just need to go through the array, calculate the current sum and save number of all seen PreSum to a HashMap.
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(); //key: preSum, value: the count of preSum
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
