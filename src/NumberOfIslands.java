import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    /**
     * Medium (F,G,A,M)
     * follow up:
     * 1.remove island that less than k size. 类似数岛，区别在于要先算出岛的大小，如果岛小于k，就把整个岛删除掉。
     * see the complete code in the end
     * 2.largest size of island instead of number of islands (LC 200). 就做了这一道题，可能是做得太慢。
     * see the complete code in the end
     * 3.(L) 1）如果给的数组不是一个square的，是个不定长的怎么办？
     *       2）如果不光是0， 1，而是>1 （mountain）, =1 （island）, <1 （water），仍然求有多少数量的island。
     * 4.用了辅助数组完成，让去掉辅助数组再写一个。
     * ?辅助数组指的是坐标变换数组吗
     * 5.return linked list，list中每一个node代表一个岛，以及岛有多大
     */

    /**
     * BFS O(R*C);
     * Start from the top-left corner of the grid.
     * Go through each position row by row and check if it is island.
     * If it is not, skip.
     * If it is, BFS to find the whole region.
     * Mark the region as "0" when finished.
     * Number of islands increment by 1.
     */
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    /**
     * Set the starting grid to '0' to mark it as visited.
     * Add it to q  ueue to start BFS.
     * Find the region and mark all grids as '0'.
     */
    private void bfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            for (int[] dir : dirs) {
                int row = head[0] + dir[0];
                int col = head[1] + dir[1];
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
                        && grid[row][col] == '1') {
                    grid[row][col] = '0';
                    queue.offer(new int[]{row, col});
                }
            }
        }
    }

    /**
     * DFS
     */
    public int numIslandsB(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

//    public int numIslands(char[][] grid) {
//        if (grid == null) {
//            return 0;
//        }
//
//        int area = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    area = Math.max(area, bfs(grid, i, j));
//                }
//            }
//        }
//        return area;
//    }
//
//    private int bfs(char[][] grid, int i, int j) {
//        int area = 1;
//        grid[i][j] = '0';
//        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{i, j});
//        while (!queue.isEmpty()) {
//            int[] head = queue.poll();
//            for (int[] dir : dirs) {
//                int row = head[0] + dir[0];
//                int col = head[1] + dir[1];
//                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
//                        && grid[row][col] == '1') {
//                    grid[row][col] = '0';
//                    area++;
//                    queue.offer(new int[]{row, col});
//                }
//            }
//        }
//        return area;
//    }


//    public void numIslands(char[][] grid, int k) {
//        if (grid == null) {
//            return;
//        }
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    if (bfs(grid, i, j) > k) {
//                        bfsRemove(grid, i, j);
//                    }
//                }
//            }
//        }
//    }
//
//    private int bfs(char[][] grid, int i, int j) {
//        int area = 1;
//        grid[i][j] = '#';
//        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{i, j});
//        while (!queue.isEmpty()) {
//            int[] head = queue.poll();
//            for (int[] dir : dirs) {
//                int row = head[0] + dir[0];
//                int col = head[1] + dir[1];
//                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
//                        && grid[row][col] == '1') {
//                    grid[row][col] = '#';
//                    area++;
//                    queue.offer(new int[]{row, col});
//                }
//            }
//        }
//        return area;
//    }
//
//    private void bfsRemove(char[][] grid, int i, int j) {
//        grid[i][j] = 'X';
//        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{i, j});
//        while (!queue.isEmpty()) {
//            int[] head = queue.poll();
//            for (int[] dir : dirs) {
//                int row = head[0] + dir[0];
//                int col = head[1] + dir[1];
//                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
//                        && grid[row][col] == '#') {
//                    grid[row][col] = 'X';
//                    queue.offer(new int[]{row, col});
//                }
//            }
//        }
//    }
}
