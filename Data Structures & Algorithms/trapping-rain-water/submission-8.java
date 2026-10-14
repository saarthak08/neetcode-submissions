class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        int l = 0;
        int r = height.length - 1;
        int rMax = height[r];
        int lMax = height[l];
        while (l < r) {
            if (height[l] > height[r]) {
                r--;
                int curr = height[r];
                if (curr < rMax) {
                    totalWater += (rMax - curr);
                } else {
                    rMax = curr;
                }
            } else {
                l++;
                int curr = height[l];
                if (curr < lMax) {
                    totalWater += (lMax - curr);
                } else {
                    lMax = curr;
                }
            }
        }

        return totalWater;
    }
}
