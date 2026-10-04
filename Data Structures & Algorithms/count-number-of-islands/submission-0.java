class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int numOfIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    numOfIslands++;
                    visited[i][j] = true;
                    queue.offer(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int[] land = queue.poll();
                        int x = land[0];
                        int y = land[1];
                        if (x > 0 && grid[x - 1][y] == '1' && !visited[x - 1][y]) {
                            queue.offer(new int[] {x - 1, y});
                            visited[x - 1][y] = true;

                        }  if (x < m - 1 && grid[x + 1][y] == '1' && !visited[x + 1][y]) {
                            queue.offer(new int[] {x + 1, y});
                            visited[x + 1][y] = true;

                        }  if (y > 0 && grid[x][y - 1] == '1' && !visited[x][y - 1]) {
                            queue.offer(new int[] {x, y - 1});
                            visited[x][y - 1] = true;

                        }  if (y < n - 1 && grid[x][y + 1] == '1' && !visited[x][y + 1]) {
                            queue.offer(new int[] {x, y + 1});
                            visited[x][y + 1] = true;
                        }
                    }
                }
            }
        }
        return numOfIslands;
    }
}
