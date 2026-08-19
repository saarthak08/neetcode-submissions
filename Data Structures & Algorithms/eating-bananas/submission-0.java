class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        while (l <= r) {
            int m = l + (r - l) / 2;
            int totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil(((double) p / (double) m));
            }
            if (totalTime > h) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
