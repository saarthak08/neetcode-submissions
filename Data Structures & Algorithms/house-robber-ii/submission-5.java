class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Integer dp1[] = new Integer[nums.length];
        int withFirst = maxRob(0, false, nums, dp1);
        Integer dp2[] = new Integer[nums.length];
        int withoutFirst = maxRob(1, true, nums, dp2);
        return Math.max(withFirst, withoutFirst);
    }

    public int maxRob(int i, boolean canTakeLast, int[] nums, Integer[] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (i == nums.length - 1 && !canTakeLast) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        int result = Math.max(
            maxRob(i + 2, canTakeLast, nums, dp) + nums[i], maxRob(i + 1, canTakeLast, nums, dp));
        dp[i] = result;
        return result;
    }
}
