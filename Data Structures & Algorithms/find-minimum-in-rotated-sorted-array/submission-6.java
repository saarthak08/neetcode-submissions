class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < min) {
                min = nums[m];
            }
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return min;
    }
}
