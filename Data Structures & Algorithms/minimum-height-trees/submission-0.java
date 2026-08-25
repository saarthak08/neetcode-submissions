class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[][] dp = new int[n][n];
        int[][] graph = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int res = dfs(i, graph, dp, visited);
            pq.offer(new int[] {res, i});
        }
        ArrayList<Integer> result = new ArrayList<>();
        int prevVal = -1;
        while (!pq.isEmpty()) {
            int[] polledVal = pq.poll();
            if (prevVal == -1) {
                prevVal = polledVal[0];
                result.add(polledVal[1]);
            } else if (prevVal < polledVal[0]) {
                return result;
            } else {
                result.add(polledVal[1]);
            }
        }
        return result;
    }

    public int dfs(int s, int graph[][], int[][] dp, boolean[] visited) {
        if (visited[s]) {
            return 0;
        }
        visited[s] = true;
        int depth = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[s][i] == 1 && !visited[i]) {
                int temp;
                if (dp[s][i] != 0) {
                    temp = dp[s][i];
                } else {
                    temp = dfs(i, graph, dp, visited);
                }
                if (temp > depth) {
                    depth = temp;
                }
            }
        }
        return depth + 1;
    }
}