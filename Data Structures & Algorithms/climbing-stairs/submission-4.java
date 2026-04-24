class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return climb(n, dp);
    }

    public int climb(int n, int[] dp) {
        if(n==1) {
            return 1;
        }
        if(n==2) {
            return 2;
        }
        int result;
        if(dp[n]!=-1) {
            result = dp[n];
        } else {
            result = climb(n-1,dp) + climb(n-2,dp);
            dp[n] = result;
        }
        return result;
    }
}
