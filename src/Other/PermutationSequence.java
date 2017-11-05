package Other;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    /**
     * Math O(n^2); O(1)
     */
    public String getPermutation(int n, int k) {
        k = k - 1;
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            nums.add(i);
        }
        nums.add(n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = k / fact;
            sb.append(nums.get(index));
            nums.remove(index); //O(n)
            k = k % fact;
            if (i < n - 1) {
                fact /= n - 1 - i;
            }
        }
        return sb.toString();
    }
//    public String getPermutation(int n, int k) {
//        StringBuilder sb = new StringBuilder();
//        dfs(sb, n, k, 0);
//        return sb.toString();
//    }
//
//    private void dfs(StringBuilder sb, int n, int k, int count) {
//        if (sb.length() == n) {
//            count++;
//            if (count == k) {
//                return;
//            }
//        }
//
//        for (int i = 1; i <= n; i++) {
//            sb.append(i);
//            dfs(sb, n, k, count);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//    }
}
