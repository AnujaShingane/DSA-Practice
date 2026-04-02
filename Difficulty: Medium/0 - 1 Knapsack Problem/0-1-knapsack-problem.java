class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return f(n-1,W,val,wt,dp);
    }
    
    public int f(int ind,int W,int[] val,int[] wt,int[][] dp) {
        if(ind==0){
            if(wt[ind]<=W){
                return val[ind];
            }else return 0;
        }
        
        if(dp[ind][W] != -1)return dp[ind][W];
        
        int nottake = f(ind-1,W,val,wt,dp);
        
        int take = Integer.MIN_VALUE;
        if(wt[ind]<=W){
            take = val[ind] + f(ind-1,W-wt[ind],val,wt,dp);
        }
        
        return dp[ind][W] =Math.max(take,nottake);
    }
}