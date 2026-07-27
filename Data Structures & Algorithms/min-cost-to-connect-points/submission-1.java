class Solution {
    public int minCostConnectPoints(int[][] points) {
        int graph[][] = new int[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                graph[i][j] =
                    Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{0, 0});
        int visitedCount = 0;
        int res = 0;
        boolean[] visited = new boolean[points.length];
        while (!queue.isEmpty() && visitedCount < points.length) {
            int edge[] = queue.poll();
            int v = edge[0];
            int w = edge[1];
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            res += w;
            visitedCount++;
            for (int i = 0; i < points.length; i++) {
                if (!visited[i]) {
                    queue.offer(new int[]{i, graph[v][i]});
                }
            }
        }
        return res;
    }
}