// User function Template for Java

class Solution {
    public int maximumProfit(int prices[]) {
        int n = prices.length;
        int minPrice = prices[0];
        int profit = 0;
        
        for(int i = 0 ; i < n ; i++){
            minPrice=Math.min(minPrice,prices[i]);
            profit = Math.max(profit,prices[i]-minPrice);
        }
        
        return profit;
    }
}