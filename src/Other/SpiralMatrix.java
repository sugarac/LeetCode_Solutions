package Other;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /**
     * Math O(mn); O(1)
     * Use a direction matrix to record the offset for all directions, right->down->left->up.
     * Use an array of two elements that stores the number of shifts for horizontal and vertical movements, respectively.
     * (In this way, we just need one for loop instead of four.)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] range = {n, m - 1};
        int dir = 0;
        int row = 0;
        int col = -1;
//        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; //逆时针
//        int[] range = {m, n - 1};
//        int dir = 0;
//        int row = -1;
//        int col = 0;

        while (range[dir % 2] > 0) {
            for (int i = 0; i < range[dir % 2]; i++) {
                row += dirs[dir][0];
                col += dirs[dir][1];
                res.add(matrix[row][col]);
            }

            range[dir % 2]--;
            dir = (dir + 1) % 4;
        }
        return res;
    }
}
