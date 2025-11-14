class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int m = wt.length;
        int[][] dp = new int[n][W+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return func(n-1,W,val,wt,dp);
    }
    
    public int func(int ind,int W, int val[], int wt[],int[][] dp) {
        if(ind==0){
            if(wt[0]<=W){
                return val[0];
            }else return 0;
        }
        
        if(W==0){
            return 0;
        }
        
        if(dp[ind][W] != -1)return dp[ind][W];
        
        int notPick = func(ind-1,W,val,wt,dp);
        int pick = Integer.MIN_VALUE;
        if(wt[ind]<=W){
            pick = val[ind] + func(ind-1,W-wt[ind],val,wt,dp);
        }
        
        return dp[ind][W] = Math.max(pick,notPick);
    }
}
