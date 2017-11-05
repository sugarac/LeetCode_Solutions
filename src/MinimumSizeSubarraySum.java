public class MinimumSizeSubarraySum {
    /**
     * Medium (F)
     */

    /**
     * 同向Two Pointers O(n);O(1)
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) { //right pointer moves, left pointer stops until while loop starts
            sum += nums[right];
            while (sum >= s) { //right pointer stops, left pointer moves
                min = Math.min(min, right - left + 1);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
