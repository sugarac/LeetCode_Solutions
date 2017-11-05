import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /**
     * Medium (F,A,U)
     * follow up:
     * 1.我用非递归写的，写完解释正确性 时间复杂度。用递归再写一遍。。解释正确性.
     * follow up 有一个class 里面有个方法next(), 每次调用next()输出上面subsets中的一个
     * http://www.1point3acres.com/bbs/thread-210792-1-1.html
     * 2.第一题prime product(给你一组素数，求所有可能的乘积) , follow-up如果有重复怎么办，就跟LC上的subsets几乎一模一样。
     */

    /**
     * DFS O(n*2^n);O(n)
     * [[],[1],[1,2],[1,2,3],
     * [1,3],
     * [2],[2,3],
     * [3]]
     * Add current subset to result first.
     * Put current number in subset.
     * Then backtrack with the rest of the numbers.
     * Reset by remove last number in subset.
     * Next iteration will move to next number then all subsets will not have this number.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }

        //找到所有以[]开头的子集
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    //找到所有以subset开头的子集
    private void dfs(List<List<Integer>> res, List<Integer> subset, int[] nums, int start) { //从nums[start]开始选择数，术语offset
        res.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    /**
     * BFS O(n*2^n);O(n)
     * [[],[1],
     * [2],[1,2],
     * [3],[1,3],[2,3],[1,2,3]]
     */
    public List<List<Integer>> subsetsB(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }

        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> subset = new ArrayList<>(res.get(j));
                subset.add(nums[i]);
                res.add(subset);
            }
        }
        return res;
    }

    public List<List<Integer>> subsetsC(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null) {
            return list;
        }
//        if (nums.length == 0) {
//            list.add(new ArrayList<>());
//            return list;
//        }

        int totalNumber = 1 << nums.length;
        for (int i = 0; i < totalNumber; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    tempList.add(nums[j]);
                }
            }
            list.add(tempList);
        }
        return list;
    }
}
