class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(minCost(cost, 1, dp), minCost(cost, 0, dp));
    }   

    int minCost(int [] cost, int index, int[] dp) {
        if(index >= cost.length) {
            return 0;
        } else {
            if(dp[index]!=-1) {
                return dp[index];
            }
            int result = cost[index] + Math.min(minCost(cost, index+1, dp), minCost(cost, index+2, dp));
            dp[index] = result;
            return result;
        }

    }
}
