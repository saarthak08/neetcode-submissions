class Solution {
    private int[] rank;
    private int[] parent;

    private int findParent(int u) {
        if (parent[u] == u) {
            return u;
        }
        int parentU = findParent(parent[u]);
        parent[u] = parentU;
        return parentU;
    }

    private boolean union(int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);

        if (parentU == parentV) {
            return false;
        }
        if (rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
        } else if (rank[parentU] < rank[parentV]) {
            parent[parentU] = parentV;
        } else {
            parent[parentU] = parentV;
            rank[parentV]++;
        }
        return true;
    }

    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        rank = new int[m * n];
        parent = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    int index = i * n + j;
                    parent[index] = index;
                    rank[index] = 0;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int index = i * n + j;
                    for (int k = 0; k < directions.length; k++) {
                        int[] direction = directions[k];
                        int newI = i + direction[0];
                        int newJ = j + direction[1];
                        if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                            int newIndex = newI * n + newJ;
                            if (grid[newI][newJ] == '1' && union(index, newIndex)) {
                                numOfIslands--;
                            }
                        }
                    }
                }
            }
        }
        return numOfIslands;
    }
}
