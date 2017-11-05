package Other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    /**
     * DFS O(n*n!); O(n)
     * If permutation’s size == nums’ length, add permutation to result.
     * For each number n in the array
     *   If n is used or n is same as the previous and the previous is not used, skip.
     *   Otherwise, add n to permutation and set n as used.
     *   Then call dfs function.
     *   Backtrack by removing last number in permutation and setting n as unused.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }

        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, boolean used[]) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            /**
             * 比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
             我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
             当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
             不应该让后面的2使用。
             */
            if (used[i] || i != 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            used[i] = true;
            dfs(res, list, nums, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
