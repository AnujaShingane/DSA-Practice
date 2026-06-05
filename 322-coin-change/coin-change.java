class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        int ans = func(n-1,amount,coins,dp);
        return ans >= (int)(1e9) ? -1 : ans;
    }

    public int func(int ind,int amount,int[] coins,int[][] dp) {
        if(ind==0){
            if(amount%coins[0]==0)return amount/coins[0];
            return (int)(1e9);
        }
        if(dp[ind][amount]!=-1)return dp[ind][amount];

        int take = (int)(1e9);
        if(amount>=coins[ind]) take = 1 + func(ind,amount-coins[ind],coins,dp);

        int nottake = func(ind-1,amount,coins,dp);

        return dp[ind][amount] = Math.min(take,nottake);
    }
}