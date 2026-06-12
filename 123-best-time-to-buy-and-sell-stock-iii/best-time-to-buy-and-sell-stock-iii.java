class Solution {
    int profit = 0;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] row : dp){
            for(int[] subrow : row){
                Arrays.fill(subrow,-1);
            }
        }

        return func(0,1,2,prices,dp);
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