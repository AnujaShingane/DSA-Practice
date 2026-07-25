class Solution {
    int maxprofit = 0;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1 ; j++){
                if(j==1){
                    dp[i][1] = Math.max((-prices[i]+dp[i+1][0])/*take*/,(0 + dp[i+1][1])); //nottake
                }else{
                    dp[i][0] = Math.max((prices[i] + dp[i+1][1])/*take*/,(0 + dp[i+1][0]) /*nottake*/);
                }
            }
        }

        return dp[0][1];
    }

    public int func(int ind,int buy,int[] prices,int[][] dp) {
        if(ind==prices.length){
            return 0;
        }

        if(dp[ind][buy]!=-1)return dp[ind][buy];
        
        if(buy==1){
            maxprofit = Math.max((-prices[ind]+func(ind+1,0,prices,dp))/*take*/,(0 + func(ind+1,1,prices,dp))); //nottake
        }else{
            maxprofit = Math.max((prices[ind] + func(ind+1,1,prices,dp))/*take*/,(0 + func(ind+1,0,prices,dp)) /*nottake*/);
        }

        return maxprofit;
    }
}