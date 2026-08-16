class Solution {
    public int search(int[] nums, int target) {
        int result = -1;
        int h = nums.length - 1;
        int l = 0;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] == target) {
                result = m;
                return result;
            }
            if (nums[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return result;
    }
}
