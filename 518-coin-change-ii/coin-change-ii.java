class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        int[] cur = new int[amount+1];

        for(int i = 0 ; i <= amount ; i++){
            if(i%coins[0]==0)prev[i] = 1;
            else prev[i] = 0;
        }

        for(int i = 1 ; i < n ; i++){
            for(int amt = 0 ; amt <= amount ; amt++){
                int notPick = prev[amt];
                int pick = 0;
                if(amt>=coins[i]){
                    pick = cur[amt-coins[i]];
                }

                cur[amt]=notPick+pick;
            }
            prev = cur.clone();
        }
        return prev[amount];
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