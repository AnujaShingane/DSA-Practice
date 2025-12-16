class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            min = Math.min(min,prices[i]);
            profit = prices[i]-min;
            max = Math.max(max,profit);
        }

        return max;
    }
}