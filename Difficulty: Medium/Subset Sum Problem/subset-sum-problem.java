class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        
        return func(n-1,arr,sum,dp);
    }
    
    static Boolean func(int ind,int[] arr,int sum,Boolean[][] dp) {
        if(sum==0)return true;
        if(ind==0)return arr[ind]==sum;
        
        if(dp[ind][sum]!=null)return dp[ind][sum];
        
        boolean take = false;
        if(arr[ind]<=sum)take = func(ind-1,arr,sum-arr[ind],dp);
        boolean nottake = func(ind-1,arr,sum,dp);
        
        return dp[ind][sum] = take || nottake;
    }
}