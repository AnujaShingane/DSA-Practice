class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        // for(int i = 1 ; i < n ; i++){
        //     for(int j = 0 ; j <= amount ; j++){
        //         int notPick = dp[i-1][j];
        //         int pick = Integer.MAX_VALUE;
        //         if(j>=coins[i]){
        //             pick = 1+dp[i][j-coins[i]];
        //         }
        //         else dp[i][j]=Math.min(notPick,pick);
        //     }
        // }

        int ans = func(n-1,amount,coins,dp);
        if(ans >= (int)1e9)return -1;
        else return ans;
    }

    public int func(int ind, int target,int[] coins,int[][] dp) {
        if(ind==0){
            if(target%coins[ind]==0)return target/coins[ind];
            else return (int)1e9;
        }
        if(dp[ind][target]!=-1)return dp[ind][target];
        int notPick = func(ind-1,target,coins,dp);
        int pick = Integer.MAX_VALUE;
        if(target>=coins[ind]){
            pick = 1+func(ind,target-coins[ind],coins,dp);
        }

        return dp[ind][target]=Math.min(notPick,pick);
    }

    private void printDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print("Row " + i + ": ");
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}