class Solution {
    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int visitCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j, 0});
                }
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    visitCount++;
                }
            }
        }
        int result = 0;
        int visitedCount = 0;
        while (!queue.isEmpty()) {
            int[] rotten = queue.poll();
            int x = rotten[0];
            int y = rotten[1];
            int z = rotten[2];
            if (x > 0 && grid[x - 1][y] == 1) {
                grid[x - 1][y] = 2;
                queue.offer(new int[] {x - 1, y, z + 1});
            }
            if (x < grid.length - 1 && grid[x + 1][y] == 1) {
                grid[x + 1][y] = 2;
                queue.offer(new int[] {x + 1, y, z + 1});
            }
            if (y > 0 && grid[x][y - 1] == 1) {
                grid[x][y - 1] = 2;
                queue.offer(new int[] {x, y - 1, z + 1});
            }
            if (y < grid[0].length - 1 && grid[x][y + 1] == 1) {
                grid[x][y + 1] = 2;
                queue.offer(new int[] {x, y + 1, z + 1});
            }
            if (result < z) {
                result = z;
            }
            visitedCount++;
        }
        if (visitedCount != visitCount) {
            return -1;
        } else {
            return result;
        }
    }
}
