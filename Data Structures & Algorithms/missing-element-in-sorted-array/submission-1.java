class Solution {
    public int missingElement(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int lNum = nums[0];
        while (l <= r) {
            int m = l + (r - l) / 2;
            int expectedValue = nums[0] + m;
            if (expectedValue == nums[m]) {
                lNum = nums[m];
                l = m + 1;
            } else {
                int diff = nums[m] - lNum - 1;
                if (k <= diff) {
                    return lNum + k;
                } else {
                    lNum = nums[m];
                    k = k - diff;
                    l = m + 1;
                }
            }
        }
        return nums[nums.length - 1] + k;
    }
}
