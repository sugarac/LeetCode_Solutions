package NonFacebookTag;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    /**
     * Medium
     */

    /**
     * DFS O(9*2^n);O(n)
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, new ArrayList<>(), k, 1, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> comb, int k, int start, int remain) {
        if (comb.size() == k && remain == 0) { //add comb.size() == k
            res.add(new ArrayList<>(comb));
        }

        for (int i = start; i <= 9; i++) {//nums.length is fixed to 9
            comb.add(i);
            dfs(res, comb, k, i + 1, remain - i); //数组固定为1到9，每个数只能用一次
            comb.remove(comb.size() - 1);
        }
    }
}
