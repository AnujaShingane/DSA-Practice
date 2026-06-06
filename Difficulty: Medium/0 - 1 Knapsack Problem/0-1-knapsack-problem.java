class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return func(n-1,W,val,wt,dp);
    }
    
    public int func(int ind,int W,int[] val,int[] wt,int[][] dp) {
        if(ind==0){
            if(W>=wt[ind])return val[ind];
            else return 0;
        }
        if(dp[ind][W] != -1)return dp[ind][W];
        
        int take = Integer.MIN_VALUE;
        if(W>= wt[ind]) take = val[ind] + func(ind-1,W-wt[ind],val,wt,dp);
        
        int nottake = func(ind-1,W,val,wt,dp);
        
        return dp[ind][W] = Math.max(take,nottake);
    }
}
