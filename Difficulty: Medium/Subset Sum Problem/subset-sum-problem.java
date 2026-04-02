class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n+1][sum+1];
        return func(n-1,sum,arr,dp);
    }
    
    static boolean func(int ind,int target,int[] arr,Boolean[][] dp){
        if(target==0)return true;
        if(ind==0)return arr[ind]==target;
        
        if(dp[ind][target]!=null)return dp[ind][target];
        
        boolean nottake = func(ind-1,target,arr,dp);
        boolean take = false;
        if(arr[ind]<=target)take = func(ind-1,target-arr[ind],arr,dp);
        
        return dp[ind][target] = take || nottake;
    }
}