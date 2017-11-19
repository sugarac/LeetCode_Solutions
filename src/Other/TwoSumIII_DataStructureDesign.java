package Other;

import java.util.*;

public class TwoSumIII_DataStructureDesign {
    /**
     * Solution1: HashMap O(1) add, O(n) find, O(n) space
     * Use a HashMap to store added numbers.
     * Use HashMap iterator to traverse map and check if exists two sum.
     * <p>
     * Solution2 (fast): HashMap + ArrayList O(1) add, O(n) find, O(n) space
     * Use a ArrayList to store all numbers and traverse the ArrayList to check if exists two sum.
     */
    class TwoSum {
        Map<Integer, Integer> map; //oj上，在这里初始化效率比在构造函数中初始化高
//        List<Integer> nums ;

        public TwoSum() {
            map = new HashMap<>();
//            nums = new ArrayList<>();
        }

        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
//            nums.add(number);
        }

        public boolean find(int value) {
            Iterator<Integer> iter = map.keySet().iterator();
            while (iter.hasNext()) {
                int num1 = iter.next();
                int num2 = value - num1;
                if (map.containsKey(num2)) {
                    if (num1 != num2 || map.get(num1) > 1) {
                        return true;
                    }
                }
            }

//            for (int num1 : nums) {
//                int num2 = value - num1;
//                if (map.containsKey(num2)) {
//                    if (num1 != num2 || map.get(num1) > 1) {
//                        return true;
//                    }
//                }
//            }

            return false;
        }
    }

    /**
     * Solution3 (TLE): HashSet O(n) add, O(1) find, O(n^2) space
     * Use a HashSet to store all numbers and the other to store all sums.
     */
    class TwoSumB {
        Set<Integer> nums;
        Set<Integer> sums;

        public TwoSumB() {
            nums = new HashSet<>();
            sums = new HashSet<>();
        }

        public void add(int number) {
            if (nums.contains(number)) {
                sums.add(number * 2);
            } else {
                Iterator<Integer> iter = nums.iterator();
                while (iter.hasNext()) {
                    sums.add(iter.next() + number);
                }

                nums.add(number);//不能放在上面，因为有corner case: ["TwoSum","add","find"] [[],[0],[0]]
            }
        }

        public boolean find(int value) {
            return sums.contains(value);
        }
    }
}
