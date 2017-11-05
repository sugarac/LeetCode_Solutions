import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    /**
     * Medium (F)
     * follow up:
     * 1.第一题prime product(给你一组素数，求所有可能的乘积) , follow-up如果有重复怎么办
     */

    /**
     * DFS O(n*2^n);O(n)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }

        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> subset, int[] nums, int start) {
        res.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            dfs(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
