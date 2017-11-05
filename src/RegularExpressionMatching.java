public class RegularExpressionMatching {
    /**
     * Hard (F,G,U,Ai,T)
     * follow up:
     * 1.优化空间
     * 2.递归实现
     */

    /**
     * DP O(mn);O(mn)
     */
    public boolean isMatchB(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; //两个空串，定义为匹配true
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2]; //不能写成dp[0][j] = true, j是偶数时才为true
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
/*                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1]; //s和p各退1个字符比较，对角线方向
                }
                if (p.charAt(j - 1) == '*') { //can use j > 1 to avoid p'start is '*', which is tested by LintCode
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') { //p.charAt(j - 2) 是*前面的字符
                        //a* counts as empty || a* counts as single or multiple a, so it’ not necessary to add dp[i][j - 1]
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2]; //a* can only counts as empty. p退2个字符和s比较，从上向下方向
                    }
                }*/
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.');
                } else {
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.');
                }
            }
        }
        return dp[m][n];
    }

    /**
     * DP O(mn);O(n) 只能去行留列，因为i只有2个状态要记录，j有3个
     */
    public boolean isMatchC(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[j] = dp[j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            boolean pre = dp[0];
            dp[0] = false;
            for (int j = 1; j <= n; j++) {
                boolean temp = dp[j];
                if (p.charAt(j - 1) != '*') {
                    dp[j] = pre && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.');
                } else {
                    dp[j] = dp[j - 2] || dp[j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.');
                }
                pre = temp;
            }
        }
        return dp[n];
    }

    /**
     * Recursive O(2^n);O(n), n is length of p (each part can be matched or not matched)
     */
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }

        if (p.charAt(1) != '*') { // next char is not '*': must match current character
            if (s.length() == 0) {
                return false;
            }
            return (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
                    && isMatch(s.substring(1), p.substring(1));
        } else {// next char is *
            while (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
    }
    /*    public boolean isMatch(String s, String p) { //太精简，看不懂
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2))
                    || !s.isEmpty()
                    && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                    && isMatch(s.substring(1), p);
        } else {
            return !s.isEmpty()
                    && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                    && isMatch(s.substring(1), p.substring(1));
        }
    }*/
}
