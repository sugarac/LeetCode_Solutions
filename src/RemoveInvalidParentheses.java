import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    /**
     * Hard (F)
     * follow up:
     * 1.考简化版，只输出一个有效结果
     * 不用DFS，用two-pass
     * 2.返回需要remove括号的个数 http://www.1point3acres.com/bbs/thread-292326-1-1.html
     */

    /**
     * DFS O(n*k), k: # of recursion calls
     * 1.use a counter to check if a string of parentheses is valid
     * 2.restrict  to remove the first ) in a series of consecutive )s to avoid duplicate results
     * 3.After the removal, the prefix is then valid. We then call the function recursively to solve the rest of the string
     * 4.keep tracking the last removal position and only remove ‘)’ after that.
     * 5.reverse the string and reuse the code
     */

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }

        dfs(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }

    private void dfs(List<String> res, String s, int iStart, int jStart, char[] par) {
        int count = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) {
                count++;
            }
            if (s.charAt(i) == par[1]) {
                count--;
            }
            if (count >= 0) {
                continue;
            }
            for (int j = jStart; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == jStart || s.charAt(j) != s.charAt(j - 1))) {
                    dfs(res, s.substring(0, j) + s.substring(j + 1), i, j, par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            dfs(res, reversed, 0, 0, new char[]{')', '('});
        } else {
            res.add(reversed);
        }
    }

    /**
     * 简化版，只输出一个有效结果，15年3月就有此题
     * two-pass O(n);O(1)
     */
    public String removeInvalidParenthesesB(String s) {
        if (s == null) {
            return null;
        }

        s = remove(s, new char[]{'(', ')'});
        String reversed = remove(new StringBuilder(s).reverse().toString(), new char[]{')', '('});
        return new StringBuilder(reversed).reverse().toString();
    }

    private String remove(String s, char[] par) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) {
                count++;
            }
            if (s.charAt(i) == par[1]) {
                count--;
            }
            if (count >= 0) {
                continue;
            }
            s = s.substring(0, i) + s.substring(i + 1);
            i--;
            count++;
        }
        return s;
    }
}


