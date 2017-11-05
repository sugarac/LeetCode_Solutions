package LowFrequency;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    /**
     * Two-pass O(n);O(1)
     * Scan from the beginning to store the result of products of integers on the left.
     * Scan from the end to start to generate final result.
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n  = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    /**
     * Array. One-pass O(n);O(1)
     * The product is actually composed of two parts, the integers on the left, and integers on the right.
     * For a naive O(n) Time, O(n) Space solution.
     * You can use two arrays to store products from the beginning and from the end.
     * Then multiply each position in the two arrays to generate result.
     * If we want to reduce space usage to O(1), we can just replace the two arrays with two integers.
     */
    public int[] productExceptSelfB(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int left = 1; // Product of integers before i.
        int right = 1; // Product of integers after n-1-i.
        for (int i = 0; i < nums.length; i++) {
            res[i] *= left; // Update result in the front.
            left *= nums[i]; // Update left.
            res[n - 1 - i] *= right; // Update result at the end.
            right *= nums[n - 1 - i]; // Update right.
        }
        return res;
    }
}
