class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        if (intervals.length == 0)
            return count;
        Arrays.sort(intervals,
            Comparator.comparingInt((int[] row) -> row[0]));
        int endI = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (endI > intervals[i][0]) {
                count++;
                endI = Math.min(endI, intervals[i][1]);
            } else {
                endI = intervals[i][1];
            }
        }
        return count;
    }
}