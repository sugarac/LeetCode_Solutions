package Other;

public class SurroundedRegions {
    /**
     * Solution1: DFS O(mn); O(max(m, n))
     * Check the four borders of the matrix. If there is an element is 'O', change it and all its neighbor 'O' to '*'.
     * Then change all the rest ‘O’ to ‘X’ and ‘*’ to ‘O’.
     */
    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) {
            return;
        }

        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            check(board, i, 0, row, col);
            if (col > 1) {
                check(board, i, col - 1, row, col);
            }
        }
        for (int j = 1; j < col - 1; j++) {
            check(board, 0, j, row, col);
            if (row > 1) {
                check(board, row - 1, j, row, col);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = board[i][j] == '*' ? 'O' : 'X';
            }
        }
    }

    private void check(char[][] board, int i, int j, int row, int col) {
        if (board[i][j] == 'O') {
            board[i][j] = '*';
            if (i > 1) { //如果改成>=，可能会导致栈溢出 https://discuss.leetcode.com/topic/17224/a-really-simple-and-readable-c-solution-only-cost-12ms
                check(board, i - 1, j, row, col);
            }
            if (j > 1) {
                check(board, i, j - 1, row, col);
            }
            if (i + 1 < row) {
                check(board, i + 1, j, row, col);
            }
            if (j + 1 < col) {
                check(board, i, j + 1, row, col);
            }
        }
    }
}
