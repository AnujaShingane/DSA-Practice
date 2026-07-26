class Solution {
    int maxprofit = 0;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return func(0,1,prices,dp);
    }

    public int func(int ind,int buy,int[] prices,int[][] dp) {
        if(ind>=prices.length){
            return 0;
        }

        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }

        if(buy==1){
            maxprofit = Math.max(-prices[ind]+func(ind+1,0,prices,dp),0+func(ind+1,1,prices,dp));
        }else{
            maxprofit = Math.max(prices[ind]+func(ind+2,1,prices,dp),0+func(ind+1,0,prices,dp));
        }

        return dp[ind][buy] = maxprofit;
    }
}