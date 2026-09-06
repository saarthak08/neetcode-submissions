class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }
        int minNum = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > minNum) {
                if((prices[i] - minNum) > maxProfit) {
                    maxProfit = prices[i] - minNum;
                }
            } else {
                minNum = prices[i];
            }
        }
        return maxProfit;
    }
}
