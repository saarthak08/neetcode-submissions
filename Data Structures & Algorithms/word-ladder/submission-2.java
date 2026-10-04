class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord) || !wordList.contains(endWord)) {
            return 0;
        }

        int m = wordList.size();
        int n = wordList.get(0).length();

        HashMap<String, Integer> map = new HashMap<>();
        int index = 1;
        for (String str : wordList) {
            map.put(str, index++);
        }

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= m; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int cnt = 0;
                String str1 = wordList.get(i);
                String str2 = wordList.get(j);
                for (int k = 0; k < n; k++) {
                    if (str1.charAt(k) != str2.charAt(k)) {
                        cnt++;
                    }
                }
                if (cnt == 1) {
                    adjList.get(map.get(str1)).add(map.get(str2));
                    adjList.get(map.get(str2)).add(map.get(str1));
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int cnt = 0;
            String str = wordList.get(i);
            for (int j = 0; j < n; j++) {
                if (beginWord.charAt(j) != str.charAt(j)) {
                    cnt++;
                }
            }
            if (cnt == 1) {
                adjList.get(0).add(map.get(str));
                adjList.get(map.get(str)).add(0);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int result = 1;
        int destinationIndex = map.get(endWord);
        int[] distance = new int[m+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destinationIndex) {
                return distance[destinationIndex];
            }
            for (Integer neighbour : adjList.get(node)) {
                if (distance[node] + 1 < distance[neighbour]) {
                    queue.offer(neighbour);
                    distance[neighbour] = distance[node] + 1;
                }
            }
            result++;
        }
        return 0;
    }
}
