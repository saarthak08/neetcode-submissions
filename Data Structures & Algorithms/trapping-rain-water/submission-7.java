class Solution {
    public int trap(int[] arr) {
        int r = arr.length - 1;
        int l = 0;
        int leftMax = arr[l];
        int rightMax = arr[r];
        int res = 0;
        while (l < r) {
            if(leftMax > rightMax) {
                r--;
                rightMax = Math.max(rightMax, arr[r]);
                res += (rightMax - arr[r]);
            } else {
                l++;
                leftMax = Math.max(leftMax, arr[l]);
                res += (leftMax - arr[l]);
            }
        }
        return res;
    }
}
