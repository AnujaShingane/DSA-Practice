class Solution {
    int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        
        return func(n-1,height,dp);
    }
    
    int func(int ind,int[] height,int[] dp) {
        if(ind==0)return 0;
        if(dp[ind] != -1)return dp[ind];
        
        int one = Math.abs(height[ind]-height[ind-1]) + func(ind-1,height,dp);
        int two = Integer.MAX_VALUE;
        if(ind>1) two = Math.abs(height[ind]-height[ind-2]) + func(ind-2,height,dp);
        
        return dp[ind] = Math.min(one,two);
    }
}
