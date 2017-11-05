package LowFrequency;

public class MaximalRectangle {
    /**
     * Hard (F) 太难，先放着
     */
    public int maximalRectangle(char[][] matrix) {
        /**
         * idea: using [LC84 Largest Rectangle in Histogram]. For each row
         * of the matrix, construct the histogram based on the current row
         * and the previous histogram (up to the previous row), then compute
         * the largest rectangle area using LC84.
         */
        int m = matrix.length, n;
        if (m == 0 || (n = matrix[0].length) == 0)
            return 0;

        int i, j, res = 0;
        int[] heights = new int[n];
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (matrix[i][j] == '0')
                    heights[j] = 0;
                else
                    heights[j] += 1;
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        /**
         * idea: scan and store if a[i-1]<=a[i] (increasing), then as long
         * as a[i]<a[i-1], then we can compute the largest rectangle area
         * with base a[j], for j<=i-1, and a[j]>a[i], which is a[j]*(i-j).
         * And meanwhile, all these bars (a[j]'s) are already done, and thus
         * are throwable (using pop() with a stack).
         *
         * We can use an array nLeftGeq[] of size n to simulate a stack.
         * nLeftGeq[i] = the number of elements to the left of [i] having
         * value greater than or equal to a[i] (including a[i] itself). It
         * is also the index difference between [i] and the next index on
         * the top of the stack.
         */
        int n = heights.length;
        if (n == 0)
            return 0;

        int[] nLeftGeq = new int[n]; // the number of elements to the left
        nLeftGeq[0] = 1; // of [i] with value >= heights[i]
        int preIdx = 0, res = 0; // preIdx=the index of stack.peek(), res=max area so far

        for (int i = 1; i < n; i++) {
            nLeftGeq[i] = 1;

            // notice that preIdx = i - 1 = peek()
            while (preIdx >= 0 && heights[i] < heights[preIdx]) {
                res = Math.max(res, heights[preIdx] * (nLeftGeq[preIdx] + i - preIdx - 1));
                nLeftGeq[i] += nLeftGeq[preIdx]; // pop()
                preIdx = preIdx - nLeftGeq[preIdx]; // peek() current top
            }
            preIdx = i;
        }

        // compute the rest largest rectangle areas with (indices of) bases
        // on stack
        while (preIdx >= 0 && 0 < heights[preIdx]) {
            res = Math.max(res, heights[preIdx] * (nLeftGeq[preIdx] + n - preIdx - 1));
            preIdx = preIdx - nLeftGeq[preIdx]; // peek() current top
        }
        return res;
    }
}
