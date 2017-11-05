package NonFacebookTag;

public class DesignTicTacToe {
    /**
     * 第二道google的tag题：design tic tac toe
     * 然而design tic tac toe这道题没做过，胡乱写了个brute force的解法。
     * 面试官让优化，我说可以用dp记下之前的状态，然而没时间实现了。整个过程都很紧张，而且真的是bad luck。
     * <p>
     * 略变形，设计数据结构，return的type是boolean，玩家一个是'W', 一个是‘Z’，要求考虑：
     * 第一，如果重复了之前的坐标怎么处理，第二，不能一个玩家连续走两次。他描述问题用了5分钟，20分钟写代码问follow-up。
     */

    /**
     * O(1); O(n)
     * Use 2 arrays to record each row and column and 2 variables to record diagonal and antidiagonal.
     * If a row or column or diagonal or antidiagonal matches the length of the board, current player has won.
     */
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    //    /** Initialize your data structure here. */
    public DesignTicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) {
            diagonal += toAdd;
        }
        int n = rows.length;
        if (row + col == n - 1) {
            antiDiagonal += toAdd;
        }

        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */