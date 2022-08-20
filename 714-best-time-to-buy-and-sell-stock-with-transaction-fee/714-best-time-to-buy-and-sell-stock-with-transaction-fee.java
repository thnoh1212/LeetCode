class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buyState = -prices[0];
        int sellState = 0;
        for(int i = 1; i < prices.length; i++){
            int preBuyState = buyState;
            int preSellState = sellState;
            buyState = Math.max(buyState, preSellState - prices[i]);
            sellState = Math.max(sellState, preBuyState + prices[i] - fee);
        }
        
        return Math.max(buyState, sellState);
    }
}