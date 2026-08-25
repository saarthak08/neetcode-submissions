class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int count = countMap.computeIfAbsent(num, key -> 0);
            countMap.put(num, ++count);
        }
        PriorityQueue<int[]> pq =
            new PriorityQueue<>(Comparator.comparingInt((int a[]) -> a[0]).reversed());
        for (var entry : countMap.entrySet()) {
            pq.offer(new int[] {entry.getValue(), entry.getKey()});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int[] polled = pq.poll();
            res[i] = polled[1];
        }
        return res;
    }
}
