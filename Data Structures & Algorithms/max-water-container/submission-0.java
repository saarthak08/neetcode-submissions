class Solution {
    public int maxArea(int[] heights) {
        int maxHeight = 0;
        int l = 0;
        int r = heights.length - 1;
        while (l < r) {
            int h = Math.min(heights[l], heights[r]) * (r - l);
            if (h > maxHeight) {
                maxHeight = h;
            }
            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxHeight;
    }
}
