class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        int withFirst = maxRob(0, false, nums, dp);
        Arrays.fill(dp, -1);
        int withoutFirst = maxRob(1, true, nums, dp);
        return Math.max(withFirst, withoutFirst);
    }

    public int maxRob(int i, boolean canTakeLast, int[] nums, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (i == nums.length - 1 && !canTakeLast) {
            if(nums.length==1) {
                return nums[i];
            } else {
                return 0;
            }
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int result = Math.max(
            maxRob(i + 2, canTakeLast, nums, dp) + nums[i], maxRob(i + 1, canTakeLast, nums, dp));
        dp[i] = result;
        return result;
    }
}
