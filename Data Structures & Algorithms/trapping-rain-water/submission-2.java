class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        while (l < r) {
            if (leftMax > rightMax) {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += (rightMax - height[r]);
            } else {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += (leftMax - height[l]);
            }
        }
        return res;
    }
}
