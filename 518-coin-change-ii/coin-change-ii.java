class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return func(n-1,amount,coins,dp);
    }

    public int func(int ind,int target,int[] coins,int[][] dp) {
        if(ind==0){
            if(target%coins[ind]==0)return 1;
            else return 0;
        }
        if(dp[ind][target]!=-1)return dp[ind][target];

        int notPick = func(ind-1,target,coins,dp);
        int pick = 0;
        if(target>=coins[ind]){
            pick = func(ind,target-coins[ind],coins,dp);
        }

        return dp[ind][target]=notPick+pick;
    }
}