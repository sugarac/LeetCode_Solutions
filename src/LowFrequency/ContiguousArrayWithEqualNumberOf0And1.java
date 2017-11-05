package LowFrequency;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArrayWithEqualNumberOf0And1 {
    /**
     * Medium (F)
     */

    /**
     * HashMap O(n);O(n)
     * use counter to record the amount of 1 more than 0
     */
    public int findMaxLength(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int count = 0; //use counter to record the amount of 1 more than 0
        Map<Integer, Integer> map = new HashMap<>(); //key:count value:index
        map.put(0, -1); //start from count 0, where is a virtual index of -1.
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(count)) {
                res = Math.max(res, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return res;
    }

    /**
     * DP O(n);O(n)
     */
    public int findMaxLengthB(int[] nums) {
        // 技巧1： 让 0 的时候的数变成-1， 1 的时候还是1. 这样就可以通过记录sum 是0 的位置来判断这个subarray；
        // 技巧2： 通过Array来存这个数是否之前出现 来加快速度。
        if (nums == null) {
            return -1;
        }

        int n = nums.length;
        int[] dp = new int[n * 2 + 1];
        dp[n] = -1;
        int count = n; // 通过这个来保证他前面都是正数的index
        int res = 0;
        for (int i = 0; i < n; i++) {
//            count += nums[i] + nums[i] - 1; // 通过这个来让0 -> -1
            count += nums[i] == 0 ? -1 : 1;
            if (dp[count] == 0) {
                dp[count] = i + 1;
            } else {
                res = dp[count] == -1 ? i + 1 : Math.max(res, i + 1 - dp[count]);
            }
        }
        return res;
    }
}
