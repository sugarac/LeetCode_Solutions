package MianJin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeProductII {
    /**
     * 第一题prime product(给你一组素数，求所有可能的乘积) , follow-up如果有重复怎么办，就跟LC上的subsets几乎一模一样。
     */

    /**
     * DFS O(n*2^n);O(n)
     */
    public List<Integer> primeProduct(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }

        Arrays.sort(nums);
        dfs(res, 1, nums, 0);
        return res;
    }

    private void dfs(List<Integer> res, int product, int[] nums, int start) {
        if (product != 1) {
            res.add(product);
        }

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            product *= nums[i];
            dfs(res, product, nums, i + 1);
            product /= nums[i];
        }
    }
}
