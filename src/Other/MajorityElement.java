package Other;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int major = 0;
        int count = 0;
        for (int i = 0; i < nums.length && count <= nums.length / 2; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else {
                count = nums[i] == major ? count + 1 : count - 1;
            }
        }
        return major;
    }

    public int majorityElementB(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            if (count > nums.length / 2) {
                res = num;
                break;
            }
        }
        return res;
    }
}
