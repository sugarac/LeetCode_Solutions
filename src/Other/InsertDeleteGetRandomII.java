package Other;

import java.util.*;

public class InsertDeleteGetRandomII {
    Map<Integer, Set<Integer>> map; //if use Map<Integer, List<Integer>>, the remove operation will be done in O(n) instead of O(1)
    List<Integer> nums;
    Random rand;
//    /** Initialize your data structure here. */
    public InsertDeleteGetRandomII() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }

//    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
            map.get(val).add(nums.size());
            nums.add(val);
            return true;
        }
        map.get(val).add(nums.size());
        nums.add(val);
        return false;
    }

//    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (index < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            map.get(last).remove(nums.size() - 1);
            map.get(last).add(index);
        }

        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

//    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
