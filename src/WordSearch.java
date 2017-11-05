public class WordSearch {
    /**
     * DFS O(mn*4^k); O(k)
     * For each character c in board,
     *   Start DFS if c matches the first character of string.
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int start) {
        if (start == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(start)) {
            return false;
        }

        board[i][j] = '#';
        boolean res = dfs(board, i + 1, j, word, start + 1)
                || dfs(board, i - 1, j, word, start + 1)
                || dfs(board, i, j + 1, word, start + 1)
                || dfs(board, i, j - 1, word, start + 1);
        board[i][j] = word.charAt(start);
        return res;
    }
}
