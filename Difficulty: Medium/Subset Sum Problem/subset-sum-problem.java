class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        
        return func(n-1,arr,sum,dp);
    }
    
    static Boolean func(int ind,int[] arr,int target,Boolean[][] dp) {
        if(target==0)return true;
        if(ind==0){
            return arr[0]==target;
        }
        
        if(dp[ind][target]!=null)return dp[ind][target];
        
        boolean nottake = func(ind-1,arr,target,dp);
        boolean take = false;
        if(arr[ind]<=target)take = func(ind-1,arr,target-arr[ind],dp);
        
        return dp[ind][target] = take || nottake;
    }
}