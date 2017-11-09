package Other;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    /**
     * Solution1: DFS O(2^n); O(n)
     * ["a","a","b","b"],["a","a","bb"],["aa","b","b"],["aa","bb"]
     * During DFS, use a start index to record the start position of next palindrome.
     * If find a palindrome from start index, add it to temp list, repeat until the start index equals the length of string.
     * Then backtrack, remove last element of temp list until find a new palindrome string.
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> temp, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                dfs(res, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
