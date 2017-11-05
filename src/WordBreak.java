import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    /**
     * Medium (F,G,U,A,B,PG)
     * follow up:
     * 1.输出一组解
     * 2.dict可能很大怎么办，我说建立字典树
     */

    /**
     * DP O(m * n^2);O(n) m is the size of dict
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // for (int j = i - 1; j >= 0; j--) { //a small optimization
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    /**
     * follow up 1.输出一组解
     * 可以直接将boolean改成int，不需要第二个数组
     */
    public String wordBreakC(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();
        int[] end = new int[n + 1]; //数组的索引记录最长分段的开始位置，数组的值记录最长段的结束位置
//        end[0] = -1;//没有必要赋值为-1，因为如果有解，end[0]的值肯定会改变
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    end[j] = i; //这样导致输出的解的第一段是dict中s的最长prefix
                    break;
                }
            }
        }

        if (!dp[n]) {
            return "";
        }
        StringBuilder sb = new StringBuilder(s.substring(0, end[0]));
        int start = end[0];
        while (start < s.length()) {
            sb.append(" " + s.substring(start, end[start])); //StringBuilder append只能在尾部加字符串
            start = end[start];
        }
        return sb.toString();
    }

    public String wordBreakD(String s, List<String> wordDict) { //上面解法的简化版
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != -1 && wordDict.contains(s.substring(j, i))) {
                    dp[i] = j;
//                    System.out.println(i + " ");
                    break;
                }
            }
        }

        if (dp[n] == -1) {
            return "";
        }
        StringBuilder sb = new StringBuilder(s.substring(dp[n], n));
        int end = dp[n];
        while (end > 0) {
            sb.insert(0, s.substring(dp[end], end) + " "); //insert可以在头部加字符串，但是开销是O(n)
            end = dp[end];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        WordBreak test = new WordBreak();
        String[] words = {"Google", "Facebook", "Microsoft", "GoogleFace", "bookMicrosoft"};
        List<String> dict = new ArrayList<>(Arrays.asList(words));
        String res = test.wordBreakD("GoogleFacebookMicrosoft", dict);
        System.out.println(res);
    }

    //    DP + Trie Tree
    public class TrieNode {
        boolean isWord;
        TrieNode[] c;

        public TrieNode() {
            isWord = false;
            c = new TrieNode[128];
        }
    }

    public void addWord(TrieNode t, String w) {
        for (int i = 0; i < w.length(); i++) {
            int j = (int) w.charAt(i);
            if (t.c[j] == null) t.c[j] = new TrieNode();
            t = t.c[j];
        }
        t.isWord = true;
    }

    public boolean wordBreakB(String s, List<String> wordDict) {
        TrieNode t = new TrieNode(), cur;
        for (String i : wordDict) addWord(t, i);
        char[] str = s.toCharArray();
        int len = str.length;
        boolean[] f = new boolean[len + 1];
        f[len] = true;

        for (int i = len - 1; i >= 0; i--) {
            //System.out.println(str[i]);
            cur = t;
            for (int j = i; cur != null && j < len; j++) {
                cur = cur.c[(int) str[j]];
                if (cur != null && cur.isWord && f[j + 1]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[0];
    }
}
