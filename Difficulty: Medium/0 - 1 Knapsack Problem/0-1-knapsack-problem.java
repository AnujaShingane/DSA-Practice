class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        
        for(int w = wt[0] ; w <= W ; w++){
            dp[0][w] = val[0];
        }
        
        for(int i = 1 ; i < n ; i++){
            for(int w = 0 ; w <= W ; w++){
                int nottake = dp[i-1][w];
        
                int take = Integer.MIN_VALUE;
                if(wt[i]<=w){
                    take = val[i] + dp[i-1][w-wt[i]];
                }
                
                dp[i][w] = Math.max(take,nottake);
            }
        }
        
        return dp[n-1][W];
    }
}