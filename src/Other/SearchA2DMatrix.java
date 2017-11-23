package Other;

public class SearchA2DMatrix {
    /**
     * Solution1: Binary Search O(logn); O(1)
     * Treat the 2D matrix as a sorted list.
     * Locate the middle number by that row is middle index divide n and col is middle index mod n.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }

        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        while (start <= end) { //必须是等于
            int mid = start + (end - start) / 2;
            int midNum = matrix[mid / n][mid % n];
            if (midNum == target) {
                return true;
            }
            if (midNum < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
