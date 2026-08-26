class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        
        return func(n-1,sum,arr,dp);
    }
    
    static boolean func(int ind,int target,int[] arr,Boolean[][] dp) {
        if(target==0)return true;
        if(ind==0)return target==arr[0];
        
        if(dp[ind][target]!=null)return dp[ind][target];
        
        boolean take = false;
        if(target>=arr[ind]) take = func(ind-1,target-arr[ind],arr,dp);
        boolean nottake = func(ind-1,target,arr,dp);
        
        return dp[ind][target] = take || nottake;
    }
}