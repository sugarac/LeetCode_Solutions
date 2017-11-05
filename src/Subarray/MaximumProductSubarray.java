package Subarray;

public class MaximumProductSubarray {
    /**
     * DP O(n);O(1)
     * 1.the max cumulative product UP TO current element starting from SOMEWHERE in the past,
     * and the minimum cumulative product UP TO current element.
     * 2.if we see a negative number, the "candidate" for max should instead become the previous min product,
     * because a bigger number multiplied by negative becomes smaller, hence the swap()
     * 3.at each new element, u could either add the new element to the existing product,
     * or start fresh the product from current index (wipe out previous results), hence the 2 Math.max() lines.
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int iMax = nums[0];
        int iMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }
            iMax = Math.max(iMax * nums[i], nums[i]);
            iMin = Math.min(iMin * nums[i], nums[i]);
            max = Math.max(max, iMax);
        }
        return max;
    }
}
