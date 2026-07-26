class Solution {
    int maxprofit = 0;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return func(0,1,prices,dp,fee);
    }

    public int func(int ind,int buy,int[] prices,int[][] dp,int fee) {
        if(ind>=prices.length){
            return 0;
        }

        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }

        if(buy==1){
            maxprofit = Math.max(-prices[ind]+func(ind+1,0,prices,dp,fee),0+func(ind+1,1,prices,dp,fee));
        }else{
            maxprofit = Math.max((prices[ind]-fee)+func(ind+1,1,prices,dp,fee),0+func(ind+1,0,prices,dp,fee));
        }

        return dp[ind][buy] = maxprofit;
    }
}