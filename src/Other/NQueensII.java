package Other;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
    /**
     * Hard
     * 一开始修改I的解法后，不能通过，因为res是基本数据类型，所以要将res声明为全局变量，才能在dfs函数中将其改变
     * 虽然是计数问题，这题应该不能用DP做
     */
    int res = 0;
    public int totalNQueens(int n) {
        if (n <= 0) {
            return res;
        }

        dfs(new ArrayList<>(), n);
        return res;
    }

    private void dfs(List<Integer> cols, int n) {
        if (cols.size() == n) {
            res++;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            dfs(cols, n);
            cols.remove(cols.size() - 1);
        }
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
