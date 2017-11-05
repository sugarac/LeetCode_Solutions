import java.util.*;

public class _2Sum {
    /**
     * Easy (Many)
     * follow up:
     * 1.two sum with duplicate number, 返回所有的可能的index pairs，
     * 我用的是map<Integer, Set<Integer>>
     * 2.只要返回true or false。 follow up： how to test your function. 不要求写test case， 说思路。
     * 正确回答是阐述一遍测试体系: unit test, integration test, leak test, performance test 等等……
     * http://www.1point3acres.com/bbs/thread-198685-1-1.html
     */

    /**
     * HashMap O(n);O(n)
     * Build a mapping between number and its index.
     * For each number n in the array:
     * | Check if target - n exists in map:
     * |   If exists, return the indices.
     * | Put n and its index in map.
     * Return if not found.
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * 167. Two Sum II - Input array is sorted
     * Two Pointers O(n);O(1)
     */
    public int[] twoSumB(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left + 1, right + 1};
            }
            if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * duplicate number, 返回所有的可能的index pairs
     * HashMap & HashSet 应该是O(n^2);O(n)
     */
    public List<int[]> twoSumC(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(nums[i], set);
            } else {
                map.get(nums[i]).add(i);
            }

            if (map.containsKey(target - nums[i])) {
                for (Integer j : map.get(target - nums[i])) {
                    if (j != i) {
                        res.add(new int[]{j, i});
                        System.out.println(j + " " + i);
                    }
                }
            }
        }
        return res;
    }

    /**
     * Input array is sorted, duplicate number, 返回所有的可能的index pairs
     * Two Pointers O(n);O(1)
     */
    public List<int[]> twoSumD(int[] nums, int target) {
        if (nums == null) {
            return null;
        }


        int left = 0;
        int right = nums.length - 1;
        List<int[]> res = new ArrayList<>();
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res.add(new int[]{left, right});
                System.out.println(left + " " + right);
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
