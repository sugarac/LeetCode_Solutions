package Other;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /**
     * DFS O(n*n!); O(n)
     * If permutation’s size == nums’ length, add permutation to result.
     * For each number n in the array
     *   If permutation contains n, skip. Otherwise, add n to permutation.
     *   Then call dfs function.
     *   Reset by removing last number in permutation.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }

        dfs(res, new ArrayList<>(), nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) { //important!!!
                continue;
            }

            list.add(nums[i]);
            dfs(res, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
