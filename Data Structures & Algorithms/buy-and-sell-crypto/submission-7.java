class Solution {
    public int maxProfit(int[] prices) {
      int maxProfit = 0;
      int lowestBuy = prices[0];  
      for(int price: prices) {
        maxProfit = Math.max(maxProfit, price - lowestBuy);
        lowestBuy = Math.min(lowestBuy, price);
      }
      return maxProfit;
    }
}
