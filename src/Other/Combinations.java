package Other;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> comb, int n, int k, int start) {
        if (comb.size() == k) {
            res.add(new ArrayList<>(comb));
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            dfs(res, comb, n, k, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
