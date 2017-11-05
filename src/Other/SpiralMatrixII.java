package Other;

public class SpiralMatrixII {
    /**
     * Math O(n^2); O(1)
     * Use a direction matrix to record the offset for all directions, right->down->left->up.
     * Use an array of two elements that stores the number of shifts for horizontal and vertical movements, respectively.
     * (In this way, we just need one for loop instead of four.)
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] range = {n, n - 1};
        int dir = 0;
        int row = 0;
        int col = -1;

        while (range[dir % 2] > 0) {
            for (int i = 0; i < range[dir % 2]; i++) {
                row += dirs[dir][0];
                col += dirs[dir][1];
                res[row][col] = count++;
            }
            range[dir % 2]--;
            dir = (dir + 1) % 4;
        }
        return res;
    }
}
