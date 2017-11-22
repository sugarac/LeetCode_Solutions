package Other;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {
    /**
     *
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
