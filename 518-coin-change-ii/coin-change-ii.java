class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr : dp)Arrays.fill(arr,-1);

        return func(n-1,amount,coins, dp);
    }

    public int func(int i,int amt, int[] coins,int[][] dp) {
        if(i==0){
            if(amt%coins[i]==0)return 1;
            return 0;
        }

        if(dp[i][amt]!=-1)return dp[i][amt];

        int take = 0;
        if(amt>=coins[i])take = func(i,amt-coins[i],coins,dp);

        int nottake = func(i-1,amt,coins,dp);

        return dp[i][amt]=take+nottake;
    }
}