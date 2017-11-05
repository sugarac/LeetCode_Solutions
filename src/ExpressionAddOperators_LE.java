import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators_LE {
    /**
     * Hard (F,G)
     * follow up:
     * 1.求出结果可以是0的公式数量。
     * 用一个全局变量计数
     * 2.123456789=100， 在等式左边任意位置加上“-”或者“+”使得等式成立。Print all possible combinations.
     */

    /**
     * DFS O(n*3^n);O(n)
     */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null) {
            return res;
        }

        dfs(res, new StringBuilder(), num, 0, target, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, String num, int start, int target, long pre) {
        if (start == num.length()) {
            if (pre == target) {
                res.add(sb.toString());
            }
            return;
        }

        long cur = 0;
        for (int i = start; i < num.length(); i++) {
            if (num.charAt(start) == '0' && i != start) { //0 sequence: because we can't have numbers with multiple digits started with zero
                break;
            }

            cur = cur * 10 + num.charAt(i) - '0'; //long cur = Long.parseLong(num.substring(pos, i + 1));//bad
            int len = sb.length();
            if (start == 0) {
                dfs(res, sb.append(cur), num, i + 1, target, cur);
                sb.setLength(len);
            } else {
                dfs(res, sb.append('+').append(cur), num, i + 1, target, pre + cur);
                sb.setLength(len);
                dfs(res, sb.append('-').append(cur), num, i + 1, target, pre - cur);
                sb.setLength(len);
            }
        }
    }

    /**
     * 2.123456789=100， 在等式左边任意位置加上“-”或者“+”使得等式成立。Print all possible combinations.
     */
    public void addOperators(String num) {
        if (num == null) {
            System.out.println("null");
        }

        dfs(new StringBuilder(), num, 0, 100, 0);
    }

    private void dfs(StringBuilder sb, String num, int start, int target, long pre) {
        if (start == num.length()) {
            if (pre == target) {
                System.out.println(sb.toString());
            }
            return;
        }

        long cur = 0;
        for (int i = start; i < num.length(); i++) {
            if (num.charAt(start) == '0' && i != start) {
                break;
            }

            int len = sb.length();
            cur = cur * 10 + num.charAt(i) - '0';
            if (start == 0) {
                dfs(sb.append(cur), num, i + 1, target, cur);
                sb.setLength(len);
            } else {
                dfs(sb.append('+').append(cur), num, i + 1, target, pre + cur);
                sb.setLength(len);
                dfs(sb.append('-').append(cur), num, i + 1, target, pre - cur);
                sb.setLength(len);
            }
        }
    }
}
