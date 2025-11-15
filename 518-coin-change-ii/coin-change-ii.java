class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i = 0 ; i <= amount ; i++){
            if(i%coins[0]==0)dp[0][i] = 1;
            else dp[0][i] = 0;
        }

        for(int i = 1 ; i < n ; i++){
            for(int amt = 0 ; amt <= amount ; amt++){
                int notPick = dp[i-1][amt];
                int pick = 0;
                if(amt>=coins[i]){
                    pick = dp[i][amt-coins[i]];
                }

                dp[i][amt]=notPick+pick;
            }
        }
        return dp[n-1][amount];
    }

    // public int func(int ind,int target,int[] coins,int[][] dp) {
    //     if(ind==0){
    //         if(target%coins[ind]==0)return 1;
    //         else return 0;
    //     }
    //     if(dp[ind][target]!=-1)return dp[ind][target];

    //     int notPick = func(ind-1,target,coins,dp);
    //     int pick = 0;
    //     if(target>=coins[ind]){
    //         pick = func(ind,target-coins[ind],coins,dp);
    //     }

    //     return dp[ind][target]=notPick+pick;
    // }
}