class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxRate = -1;
        for (int pile : piles) {
            maxRate = Math.max(maxRate, pile);
        }
        int l = 1;
        int r = maxRate;
        int result = maxRate;
        while (l <= r) {
            int m = l + (r - l) / 2;
            long totalTime = 0;
            for (int pile : piles) {
                totalTime += (pile / m);
                if (pile % m != 0) {
                    totalTime += 1;
                }
            }
            if (m < result && totalTime <= h) {
                result = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return result;
    }
}
