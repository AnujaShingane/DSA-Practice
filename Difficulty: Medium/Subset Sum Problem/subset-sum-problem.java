class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        
        return func(n-1,arr,sum,dp);
    }
    
    static Boolean func(int ind,int[] arr,int target,Boolean[][] dp) {
        if(target==0)return true;
        if(ind==0)return target==arr[0];
        if(dp[ind][target]!=null)return dp[ind][target];
        
        boolean nottake = func(ind-1,arr,target,dp);
        boolean take = false;
        if(target>=arr[ind])take = func(ind-1,arr,target-arr[ind],dp);
        
        return dp[ind][target] = take || nottake;
    }
}