class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            else {
                int diff = prices[i] - minPrice;
                profit = Math.max(profit, diff);
            }
        }

        return profit;
    }
}
/*

TC: O(n)
SC: O(1)

*/