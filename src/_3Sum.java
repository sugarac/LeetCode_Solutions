import java.util.*;

public class _3Sum {
    /**
     * Medium (F,A,M,B,A)
     * follow up:
     * 1.K sum，面试官想要的是recursion，我给了一个iteratively build hashset的方法，空间复杂度我后来想了想有点难看，但是时间做到了最优，面试官比较满意，也没有细问。这套题目能正确回答big o很重要，面试官很在乎。
     * 2.没有重复数字
     * 3.不能改变数组的顺序
     * 用HashMap
     * 4.返回一组满足条件的值就行，follow up问数组里的值能重复使用怎么办？用了类似combination sum的方法递归求解。
     */

    /**
     * Two Pointers O(n^2);O(1)
     * Sort given array first.
     * Traverse the array with 1 pointer.
     * Use another 2 pointers from both start(i + 1) and end to find the target.
     * How to avoid duplicate? Compare current number with the previous one, if same, skip.
     * How to early prune? When current number is positive, stop.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break; // Pruning. Stop at positive integers.
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate.
            }

            int l = i + 1;
            int r = nums.length - 1;
            int sum = 0 - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l + 1]) { // Skip duplicate.
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) { // Skip duplicate.
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < sum) {
                    while (l < r && nums[l] == nums[l + 1]) { // Skip duplicate.
                        l++;
                    }
                    l++;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) { // Skip duplicate.
                        r--;
                    }
                    r--;
                }
            }
        }
        return res;
    }

    /**
     * HashMap O(n^2);O(n)
     */
    public List<List<Integer>> threeSumB(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int rest = 0 - nums[i] - nums[j];
                int count = 0;
                if (nums[i] == rest) {
                    count++;
                }
                if (nums[j] == rest) {
                    count++;
                }
                if (map.containsKey(rest) && map.get(rest) > count && rest >= nums[j]) {
                    res.add(Arrays.asList(nums[i], nums[j], rest));
                }
                while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }
}
