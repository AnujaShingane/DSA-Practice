import java.util.*;

class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        
        int[][] dp = new int[n][W+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return func(W, wt, val, n-1, dp);
    }
    
    public int func(int W, int[] wt, int[] val, int ind, int[][] dp) {
        if(ind == 0){
            if(wt[0] <= W) return val[0];
            else return 0;
        }
        
        if(W == 0) return 0;
        
        if(dp[ind][W] != -1) return dp[ind][W];
        
        int notTake = func(W, wt, val, ind-1, dp);
        
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= W){
            take = val[ind] + func(W - wt[ind], wt, val, ind-1, dp);
        }
        
        return dp[ind][W] = Math.max(take, notTake);
    }
}