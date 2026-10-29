class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        int result = r;
        while (l <= r) {
            int m = l + (r - l) / 2;
            long hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] + m - 1L) / m;
            }
            if (hours <= h) {
               result = m;
               r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return result;
    }
}
