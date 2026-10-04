class Solution {
    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        while (left < right) {
            if (leftMax > rightMax) {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
            } else {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
            }
        }
        return res;
    }
}
