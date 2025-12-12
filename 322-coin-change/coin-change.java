class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = func(coins, amount , n-1,dp);
        return (ans==1e9)?-1:ans;
    }

    public int func(int[] coins, int target , int ind,int[][] dp){
        if(target==0)return 0;      
        if(ind==0){
            if(target%coins[0]==0)return target/coins[0];
            return (int)(1e9);
        }
        if(dp[ind][target]!=-1)return dp[ind][target];

        int nottake = func(coins,target, ind-1,dp);
        int take = Integer.MAX_VALUE;
        if(target>=coins[ind]){
            take = 1+func(coins,target-coins[ind],ind,dp);
        }
        return dp[ind][target]=Math.min(take,nottake);
    }
}