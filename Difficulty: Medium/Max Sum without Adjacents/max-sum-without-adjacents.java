// User function Template for Java

class Solution {
    int findMaxSum(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        
        return func(n-1,arr,dp);
    }
    
    int func(int ind,int[] arr,int[] dp){
        if(ind==0)return arr[ind];
        if(ind<0)return 0;
        if(dp[ind]!=-1)return dp[ind];
        
        int pick=arr[ind]+func(ind-2,arr,dp);
        int notpick=0+func(ind-1,arr,dp);
        
        return dp[ind]=Math.max(pick,notpick);
    }
}