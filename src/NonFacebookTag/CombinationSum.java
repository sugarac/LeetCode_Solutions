package NonFacebookTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /**
     * Medium
     */

    /**
     * DFS O(n*2^n), O(target/min(candidates[]) * 2^n;O(n)
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        dfs(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> comb, int[] candidates, int start, int remain) {
//        if (remain < 0) {
//            return;
//        }
        if (remain == 0) {
            res.add(new ArrayList<>(comb));
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) {
                break;
            }
            comb.add(candidates[i]);
            dfs(res, comb, candidates, i, remain - candidates[i]); //数组无重复，每个数可用多次
            comb.remove(comb.size() - 1);
        }
    }
}
