import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    /**
     * Medium (F,G,A,U,D)
     * follow up:
     * 1.面试官上来让递归，写完后面试官说要打印不要返回，于是马上改。改完后问时间空间复杂度。问空间上能否优化。
     * 2.变形，变成用这些组合测密码，有个回传密码是否正确的函数可用，问正确的密码。
     */

    /**
     * DFS O(n*4^n);O(n)
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        dfs(res, new StringBuilder(), digits, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, String digits, int start) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int len = sb.length();
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] letter = letters[digits.charAt(start) - '0'].toCharArray();
        for (char c : letter) {
            dfs(res, sb.append(c), digits, start + 1);
            sb.setLength(len); //backtrack
        }
    }
/*    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        dfs(digits, 0, res, "");
        return res;
    }

    private void dfs(String digits, int start, List<String> res, String comb) {
        if (comb.length() == digits.length()) {
            res.add(comb);
            return;
        }

        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] letter = letters[digits.charAt(start) - '0'].toCharArray();
        for (char c : letter) {
            dfs(digits, start + 1, res, comb + c);
        }
    }*/

/*    public void letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            System.out.println("");
        }

        dfs(digits, 0, "");
    }

    private void dfs(String digits, int start, String comb) {
        if (comb.length() == digits.length()) {
            System.out.println(comb);
            return;
        }

        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] letter = letters[digits.charAt(start) - '0'].toCharArray();
        for (char c : letter) {
            dfs(digits, start + 1, comb + c);
        }
    }*/

    /**
     * BFS
     */
    public List<String> letterCombinationsB(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("");
        for (int i = 0; i < digits.length(); i++) {
            char[] letter = letters[digits.charAt(i) - '0'].toCharArray();
            while (queue.peek().length() == i) {
                String s = queue.poll();
                for (char c : letter) {
                    queue.offer(s + c);
                }
            }
        }
        return queue;
    }
}
