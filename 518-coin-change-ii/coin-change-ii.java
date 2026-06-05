class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(n-1,amount,coins,dp);
    }

    public int func(int ind,int amount,int[] coins,int[][] dp) {
        if(ind==0){
            if(amount%coins[0]==0)return 1;
            return 0;
        }
        if(dp[ind][amount]!=-1)return dp[ind][amount];

        int take = 0;
        if(amount>=coins[ind]) take = func(ind,amount-coins[ind],coins,dp);

        int nottake = func(ind-1,amount,coins,dp);

        return dp[ind][amount] = take + nottake;
    }
}