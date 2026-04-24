class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxMoney(0, dp, nums);
    }

    public int maxMoney(int i, int[] dp, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int res = Math.max(nums[i] + maxMoney(i + 2, dp, nums), maxMoney(i + 1, dp, nums));
        dp[i] = res;
        return res;
    }
}
