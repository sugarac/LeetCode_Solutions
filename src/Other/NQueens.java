package Other;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /**
     * Hard 参考令狐冲的写法，简单易懂
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        dfs(res, new ArrayList<>(), n);
        return res;
    }

    private void dfs(List<List<String>> res, List<Integer> cols, int n) {
        if (cols.size() == n) {
            res.add(drawChessBoard(cols));
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            dfs(res, cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    private List<String> drawChessBoard(List<Integer> cols) {
        List<String> chessBoard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? "Q" : ".");
            }
            chessBoard.add(sb.toString());
        }
        return chessBoard;
    }

    private boolean isValid(List<Integer> cols, int col) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            if (col == cols.get(rowIndex)) {
                return false;
            }
            if (row + col == rowIndex + cols.get(rowIndex)) {
                return false;
            }
            if (row - col == rowIndex - cols.get(rowIndex)) {
                return false;
            }
        }
        return true;
    }
}
