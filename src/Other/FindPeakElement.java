package Other;

public class FindPeakElement {
    /**
     *
     */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1]) { //uphill
                start = mid;
            } else {
                end = mid; //downhill
            }
        }

        if (nums[start] < nums[end]) {
            return end;
        }
        return start;
    }
}
