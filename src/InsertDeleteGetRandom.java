import java.util.*;

public class InsertDeleteGetRandom {
    /**
     * Medium (F,G,A,U,Y)
     * follow up:
     * 1.allowing duplicates.(LC 381)
     * https://discuss.leetcode.com/topic/53216/java-solution-using-a-hashmap-and-an-arraylist-along-with-a-follow-up-131-ms/54
     * The idea is to add a set to the hashMap to remember all the locations of a duplicated number.
     * 相关面试题(L): http://www.1point3acres.com/bbs/thread-156459-1-1.html
     */

    /**
     * HashMap + ArrayList O(1);O(n)
     * Use ArrayList to store all values
     * Use HashMap to store values and their indexes in ArrayList
     * Every insert : index + 1
     * Every remove : Put the last value in the removed locatio and remove the last one
     */
    Map<Integer, Integer> map;
    //    HashMap<Integer, Set<Integer>> map;
    List<Integer> nums;
    Random rand;

    //    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        map = new HashMap<>();
//        map = new HashMap<Integer, Set<Integer>>();
        nums = new ArrayList<>();
        rand = new Random();
    }

    //    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
//        if (!map.containsKey(val)) {
//            map.put(val, new HashSet<Integer>());
//        }

        map.put(val, nums.size());
//        map.get(val).add(nums.size());
        nums.add(val);
        return true;
    }

    //    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int last = nums.get(nums.size() - 1);//no need to add this code: if (index < nums.size() - 1) //not the last one than swap the last one with this val
        map.put(last, index);
        nums.set(index, last);
//        int index = map.get(val).iterator().next(); //get index of val in ArrayList
//        map.get(val).remove(index); //remove index of val in HashSet
//        if (index < nums.size() - 1) { //this code is necessary here, otherwise will lead to out of bound
////        int last = nums.get(nums.size() - 1 ); //get the last val
////        nums.set(index , last); //replace val by last val
////        map.get(last).remove(nums.size() - 1); // remove index of last val
////        map.get(last).add(index); //add new index of last val
//        }


        map.remove(val);
//        if (map.get(val).isEmpty()) map.remove(val); //if val's HashSet is empty, remove key of val
        nums.remove(nums.size() - 1);
        return true;
    }

    //    Get a random element from the set.
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */