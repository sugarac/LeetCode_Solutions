package NonFacebookTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    /**
     * Medium
     */

    /**
     * DFS O(n*2^n);O(n)
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        dfs(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> comb, int[] candidates, int start, int remain) {
        if (remain == 0) {
            res.add(new ArrayList<>(comb));
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) {
                break;
            }
            if (i != start && candidates[i] == candidates[i - 1]) { //skip duplicates
                continue;
            }
            comb.add(candidates[i]);
            dfs(res, comb, candidates, i + 1, remain - candidates[i]); //数组有重复，每个数只能用一次
            comb.remove(comb.size() - 1);
        }
    }
}
