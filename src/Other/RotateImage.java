package Other;

public class RotateImage {
    /**
     * O(n^2); O(1)
     * Reverse matrix from up to down, then swap the symmetrical number in matrix.
     * 如果是左右翻转，就要用两个for循环，这和二维数组的存储方式有关，因为是按行存储
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int s = 0;
        int e = matrix.length - 1;
        while (s < e) {
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++;
            e--;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
