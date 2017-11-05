import java.util.ArrayList;
import java.util.List;

public class DecodeWays {
    /**
     * Medium (F,U,M)
     * follow up:
     * 1.优化空间复杂度
     * 2.如果给的value不连续，比如a:78, b:539, ..., 怎么办。。我说可以backtracking，然后简单说了一下怎么搞。
     * 还可以用dp，每次判断一个新的string的时候，例如判断123456， 可以遍历26个字母对应的每个number， 看该number能否作为这个String的结尾，
     * 如果可以，就可以写dp[i] += dp[i-L]， 由于String每次前进一位只要遍历26次，所以复杂度还是O（n）。
     * 3.(A)Return all decode ways
     * 4.把input的string里面加上一些*符号，这些*符号可以代表0~9之间任意一个数字，求此时的decode ways。
     * http://www.1point3acres.com/bbs/thread-230947-1-1.html
     */

    /**
     * DP O(n);O(n)
     * dp[i] means the number of ways to decode first i chars, so the size of array is n + 1.
     * dp[0] means an empty string will have one way to decode, dp[1] means the way to decode a string of size 1.
     * Then check one digit and two-digit combination and save the results along the way. In the end, dp[n] will be the result.
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        //https://discuss.leetcode.com/topic/35840/java-clean-dp-solution-with-explanation/16
        dp[0] = 1; //只是为了后续递推计算而赋值，没有实际意义
        dp[1] = 1; //dp[1] = s.charAt(0) == '0' ? 0 : 1; //直接在异常检测处返回更好
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') { //高效简洁 //int first = Integer.valueOf(s.substring(i - 1, i));
                dp[i] = dp[i - 1];
            }
            int two = s.charAt(i - 1) - '0' + (s.charAt(i - 2) - '0') * 10;//用这个效率更高 //int two = Integer.valueOf(s.substring(i - 2, i));
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    /**
     * DP O(n);O(1)
     */
    public int numDecodingsB(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int pre = 1;
        int cur = 1;
        for (int i = 2; i <= s.length(); i++) {
            int temp = cur;
            cur = s.charAt(i - 1) != '0' ? cur : 0;
            int two = s.charAt(i - 1) - '0' + (s.charAt(i - 2) - '0') * 10;
            cur += two >= 10 && two <= 26 ? pre : 0;
            pre = temp;
        }
        return cur;
    }

    /**
     * follow up 3.(A)Return all decode ways
     */
    public List<String> numDecodingsC(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        dfs(res, s, new StringBuilder(), 0);
        return res;
    }

    private void dfs(List<String> res, String s, StringBuilder sb, int i) {
        if (i == s.length()) {//if the whole string has been decoded, return 1
            res.add(sb.toString());
            return;
        }

        if (s.charAt(i) == '0') return;
        int len = sb.length();
        int num1 = Integer.valueOf(s.substring(i, i + 1));
        dfs(res, s, sb.append((char) ('A' + num1 - 1)), i + 1);
        sb.setLength(len);
        if (i < s.length() - 1 && Integer.valueOf(s.substring(i, i + 2)) <= 26) {
            int num2 = Integer.valueOf(s.substring(i, i + 2));
            dfs(res, s, sb.append((char) ('A' + num2 - 1)), i + 2);
            sb.setLength(len);
        }
    }
}
