import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    /**
     * Hard (F,G)
     */

    /**
     * DFS O(n*4^n);O(n)
     */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }

        StringBuilder sb = new StringBuilder();
        dfs(res, sb, num.toCharArray(), 0, target, 0, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, char[] num, int pos, int target, long prev, long multi) {
        if (pos == num.length) {
            if (prev == target) {
                res.add(sb.toString());
            }
            return;
        }

        long curr = 0;
        for (int i = pos; i < num.length; i++) {
            if (num[pos] == '0' && i != pos) {
                break;
            }

            curr = curr * 10 + num[i] - '0';
            int len = sb.length();
            if (pos == 0) {
                dfs(res, sb.append(curr), num, i + 1, target, curr, curr);
                sb.setLength(len);
            } else {
                dfs(res, sb.append('+').append(curr), num, i + 1, target, prev + curr, curr);
                sb.setLength(len);
                dfs(res, sb.append('-').append(curr), num, i + 1, target, prev - curr, -curr);
                sb.setLength(len);
                dfs(res, sb.append('*').append(curr), num, i + 1, target, prev - multi + multi * curr , multi * curr);
                sb.setLength(len);
            }
        }
    }
}
