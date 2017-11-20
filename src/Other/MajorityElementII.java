package Other;

import java.util.*;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            if (count > nums.length / 3 && !res.contains(num)) {
                res.add(num);
            }
        }
        return res;
    }
}
