class Solution {
    int profit = 0;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        
        // for(int i = 0 ; i <= 2 ; i++){
        //     dp[n][0][i] = dp[n][1][i] = 0;
        // }

        // for(int i = 0 ; i < n ; i++){
        //     dp[i][0][0] = dp[i][1][0] = 0;
        // }

        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1; j++){
                for(int k = 1 ; k <= 2 ; k++){
                    if(j==1){
                        profit = Math.max(-prices[i] + dp[i+1][0][k],
                                            0 + dp[i+1][1][k]);
                    }
                    else{
                        profit = Math.max(prices[i] + dp[i+1][1][k-1],
                                            0 + dp[i+1][0][k]);
                    }

                    dp[i][j][k] = profit;
                }
            }
        }

        return dp[0][1][2];
    }

    public int func(int ind,int buy,int cap,int[] prices,int[][][] dp) {
        if(ind==prices.length)return 0;
        if(cap==0)return 0;
        if(dp[ind][buy][cap]!=-1)return dp[ind][buy][cap];

        if(buy==1){
            profit = Math.max(-prices[ind] + func(ind+1,0,cap,prices,dp),
                                0 + func(ind+1,1,cap,prices,dp));
        }
        else{
            profit = Math.max(prices[ind] + func(ind+1,1,cap-1,prices,dp),
                                0 + func(ind+1,0,cap,prices,dp));
        }

        return dp[ind][buy][cap] = profit;
    }
}