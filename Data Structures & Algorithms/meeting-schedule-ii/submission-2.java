/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return 0;
        }
        Collections.sort(intervals, Comparator.comparing(a -> a.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (var interval: intervals) {
            if (minHeap.size() != 0 && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }
            minHeap.offer(interval.end);
        }
        return minHeap.size();
    }
}
