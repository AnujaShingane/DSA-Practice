class Solution {
    int profit = 0;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        int[] ahead = new int[n+1];
        int[] cur = new int[2];

        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1 ; j++){
                if(j==1){
                    profit = Math.max(-prices[i]+ahead[0],
                                        0 + ahead[1]);
                }
                else{
                    profit = Math.max(prices[i]+ahead[1],
                                        0 + ahead[0]);
                }
                cur[j] = profit;
            }
            ahead = cur;
        }

        return ahead[1];
    }
}