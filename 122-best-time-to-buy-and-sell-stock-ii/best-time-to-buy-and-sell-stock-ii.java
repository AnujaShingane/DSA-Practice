class Solution {
    int profit = 0;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;

        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1 ; j++){
                if(j==1){
                    profit = Math.max(-prices[i]+dp[i+1][0],
                                        0 + dp[i+1][1]);
                }
                else{
                    profit = Math.max(prices[i]+dp[i+1][1],
                                        0 + dp[i+1][0]);
                }
                dp[i][j] = profit;
            }
        }

        return dp[0][1];
    }

    public int func(int ind,int buy,int[] prices,int[][] dp){
        if(ind==prices.length) return 0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];

        if(buy==1){
            profit = Math.max(-prices[ind]+func(ind+1,0,prices,dp),
                                0 + func(ind+1,1,prices,dp));
        }
        else{
            profit = Math.max(prices[ind]+func(ind+1,1,prices,dp),
                                0 + func(ind+1,0,prices,dp));
        }

        return dp[ind][buy] = profit;
    }
}