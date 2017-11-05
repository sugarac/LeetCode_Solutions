package LowFrequency;

public class WildcardMatching {
    /**
     * Hard (F,G,S,Tw)
     * follow up:
     * 1.Trie实现wildcard matching (博士全职面试)
     * 2.(G)简化版，只有"*"，没有问号
     */

    /**
     * 同向Two Pointers O(mn);O(1)
     * 1.advancing both pointers when (both characters match) or ('?' found in pattern)
     * 2.* found in pattern, track index of *, only advancing pattern pointer
     * 3.current characters didn't match, last pattern pointer was *, current pattern pointer is not *, only advancing pattern pointer
     * 4.current pattern pointer is not star, last patter pointer was not *, characters do not match
     * 5.check for remaining characters in pattern
     */
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int match = 0;
        int star = -1;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                j++;
                i++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                match = i;
                j++;
            } else if (star != -1) {
                j = star + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }

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
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break; // Pruning. If found 1 mismatch, the following won't match.
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    //'*' matches empty or '*' matches s[i-1], 这种情况时，一个'*'最后可能匹配从s.charAt(j - 1)开始的很多个字符。
                    //这样就用到了'*'(向后匹配)匹配多个字符的功能，所以如果写成dp[i - 1][j - 1]，那么只用到了'*'匹配一个字符的功能。
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j]; // dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1]; //wrong
                }
            }
        }
        return dp[m][n];
    }

    /**
     * DP O(mn);O(m)
     * use pre to replace dp[i - 1][j - 1] 暂时不理解两个for循环的位置要交换
     */
    public boolean isMatchC(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int j = 1; j <= n; j++) {
            boolean pre = dp[0];
            dp[0] = dp[0] && p.charAt(j - 1) == '*';
            for (int i = 1; i <= m; i++) {
                boolean temp = dp[i];
                if (p.charAt(j - 1) != '*') {
                    dp[i] = pre && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?');
                } else {
                    dp[i] = dp[i - 1] || dp[i];
                }
                pre = temp;
            }
        }
        return dp[m];
    }
}
