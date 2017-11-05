package Other;

public class HouseRobberII {
    /**
     * Medium
     */

    /**
     * DP
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        return Math.max(rob1(nums, 0, n - 1), rob1(nums, 1, n));
    }

    public int rob1(int[] nums, int start, int end) {
        if (end - start == 1) {
            return nums[start];
        }

        int even = nums[start];
        int odd = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            if ((i - start) % 2 == 0) {
                even = Math.max(even + nums[i], odd);
            } else {
                odd = Math.max(odd + nums[i], even);
            }
        }
        return Math.max(even, odd);
    }

    /**
     * DP
     */
}
