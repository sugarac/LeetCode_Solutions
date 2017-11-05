public class IncreasingTripletSubsequence {
    /**
     * Medium (F)
     * follow up:
     * 1.问怎么test code，要求考虑corner cases。每次问问她觉得是否work，都是I don't know...........
     * 加了递增、递减和数字全部相同的例子
     */

    /**
     * DP O(n);O(1)
     * Similar to find two minimum values.
     * The only difference is we don't update second min when first min is found.
     * Otherwise n2 can be before n1, which is wrong.
     * So for each number n in nums:
     * | If n <= n1, update n1, that is the minimum.
     * | Else if n <= n2, update n2, that is the minimum after n1.
     * | Else, we find the third value, return true.
     * Return false if third value is not found.
     * Think it like we are filling three spaces.
     * The first space is the minimum.
     * When the first space is found, try to fill the second space.
     * If both are filled, when third space is filled, return true.
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null) {
            return false;
        }

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= secondMin) {
                secondMin = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
