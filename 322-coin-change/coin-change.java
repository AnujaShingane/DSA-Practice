class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        int[] cur = new int[amount+1];

        for(int amt = 0 ; amt <= amount ; amt++){
            if(amt%coins[0] == 0)prev[amt] = amt/coins[0];
            else prev[amt] = (int)1e9;
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j <= amount ; j++){
                int notPick = prev[j];
                int pick = Integer.MAX_VALUE;
                if(j>=coins[i]){
                    pick = 1+cur[j-coins[i]];
                }
                cur[j]=Math.min(notPick,pick);
            }
            prev = cur.clone();
        }

        int ans = prev[amount];
        if(ans >= (int)1e9)return -1;
        else return ans;
    }

    // public int func(int ind, int target,int[] coins,int[][] dp) {
    //     if(ind==0){
    //         if(target%coins[ind]==0)return target/coins[ind];
    //         else return (int)1e9;
    //     }
    //     if(dp[ind][target]!=-1)return dp[ind][target];
    //     int notPick = func(ind-1,target,coins,dp);
    //     int pick = Integer.MAX_VALUE;
    //     if(target>=coins[ind]){
    //         pick = 1+func(ind,target-coins[ind],coins,dp);
    //     }

    //     return dp[ind][target]=Math.min(notPick,pick);
    // }
}