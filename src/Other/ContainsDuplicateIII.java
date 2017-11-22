package Other;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {
    /**
     * Solution1: HashMap O(n); O(n)
     * Check if t < 0. Use long type to avoid overflow.
     * Maintain a sliding window, the window’s right is at i, the window’s left is k steps back.
     * Use the idea of Bucket Sort to classify the number to corresponding bucket, whose size is t +1.
     * Use HashMap to store bucket id and number.
     * If there are two item with difference <= t, one of the two will happen:
     * (1) the two in the same bucket, (2) the two in neighbor buckets.
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }

        long width = (long) t + 1;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long id = getBucketId(nums[i], width);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < width) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < width) {
                return true;
            }

            map.put(id, (long) nums[i]);
            if (i >= k) { //can only be put here
                map.remove(getBucketId(nums[i - k], width));
            }
        }
        return false;
    }

    private long getBucketId(long num, long width) {
        return num < 0 ? (num + 1) / width - 1 : num / width;
    }
}
