class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(0,1,prices,dp);
    }

    public int func(int i , int j , int[] prices,int[][] dp) {
        if(i==prices.length)return 0;
        if(dp[i][j] != -1)return dp[i][j];

        int profit = 0;
    
        if(j==1)profit = Math.max((-prices[i]+func(i+1,0,prices,dp)),(0+func(i+1,1,prices,dp)));
        else profit = Math.max((prices[i]+func(i+1,1,prices,dp)),(0+func(i+1,0,prices,dp)));
        return dp[i][j] = profit;
    }
}