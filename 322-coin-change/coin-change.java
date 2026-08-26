class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        int ans = func(n-1,amount,coins,dp);
        
        return (ans == (int)(1e9)) ? -1 : ans;
    }

    static int func(int ind,int target,int[] arr,int[][] dp) {
        if(ind==0){
            if(target%arr[0]==0){
                return target/arr[0];
            }else return (int)(1e9);
        }

        if(dp[ind][target]!=-1)return dp[ind][target];

        int take = (int)(1e9);
        if(target>=arr[ind]) take = 1 + func(ind,target-arr[ind],arr,dp);

        int nottake = func(ind-1,target,arr,dp);

        return dp[ind][target] = Math.min(take,nottake);
    }
}