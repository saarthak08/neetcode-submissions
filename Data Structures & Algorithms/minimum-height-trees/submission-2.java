class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            graph[x].add(y);
            graph[y].add(x);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int res = dfs(i, graph, dp, visited);
            pq.offer(new int[] { res, i });
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

    public int dfs(int s, List<Integer>[] graph, Map<Integer, Map<Integer, Integer>> dp, boolean[] visited) {
        if (visited[s]) {
            return 0;
        }
        visited[s] = true;
        int depth = 0;
        for (int i : graph[s]) {
            if (!visited[i]) {
                int temp;
                if (dp.containsKey(s) && dp.get(s).containsKey(i)) {
                    temp = dp.get(s).get(i);
                } else {
                    temp = dfs(i, graph, dp, visited);
                    dp.computeIfAbsent(s, k -> new HashMap<>()).put(i, temp);
                }
                if (temp > depth) {
                    depth = temp;
                }
            }
        }

        return depth + 1;
    }
}