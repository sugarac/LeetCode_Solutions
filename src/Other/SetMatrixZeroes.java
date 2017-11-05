package Other;

public class SetMatrixZeroes {
    /**
     * Solution1: O(mn); O(1)
     * Store states of each row in the first of that row.
     * Store states of each column in the first of that column.
     * (Because the state of row0 and the state of column0 would occupy the same cell,
     * I let it be the state of row0, and use another variable "col0" for column0.)
     * In the first phase, use matrix elements to set states in a top-down way.
     * In the second phase, use states to set matrix elements in a bottom-up way.
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        boolean col0 = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0) {
                matrix[i][0] = 0;
            }
        }
    }
}
