class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int missingCount = nums[m] - nums[0] - m;
            if (missingCount < k) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        int missingBeforeR = nums[r] - nums[0] - r;
        return nums[r] + (k - missingBeforeR);
    }
}