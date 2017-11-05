package Other;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    /**
     * DFS O(mnk*4^L); O(L)
     * Build a Trie to store all words and then use DFS to find all words in the board.
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode cur, List<String> res) {
        char c = board[i][j];
        if (c == '#' || cur.children[c - 'a'] == null) {
            return;
        }
        cur = cur.children[c - 'a'];
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }

        board[i][j] = '#';
        if (i > 0) { //和Word Search I不一样，这里dfs没有返回值，所以这么写比较好
            dfs(board, i - 1, j, cur, res);
        }
        if (j > 0) {
            dfs(board, i, j - 1, cur, res);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, cur, res);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, cur, res);
        }
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    //LeetCode上TLE
//    public List<String> findWords(char[][] board, String[] words) {
//        List<String> res = new ArrayList<>();
//        if (board == null || board.length == 0 || words == null) {
//            return res;
//        }
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                for (String word : words) {
//                    if (board[i][j] == word.charAt(0)) {
//                        if (dfs(board, i, j, word, 0) && !res.contains(word)) {
//                            res.add(word);
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }
//
//    private boolean dfs(char[][] board, int i, int j, String word, int start) {
//        if (start == word.length()) {
//            return true;
//        }
//
//        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(start)) {
//            return false;
//        }
//
//        board[i][j] = '#';
//        boolean res = dfs(board, i + 1, j, word, start + 1)
//                || dfs(board, i - 1, j, word, start + 1)
//                || dfs(board, i, j + 1, word, start + 1)
//                || dfs(board, i, j - 1, word, start + 1);
//        board[i][j] = word.charAt(start);
//        return res;
//    }
}
