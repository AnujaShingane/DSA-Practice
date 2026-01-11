class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        
        return func(n-1,sum,arr,dp);
    }
    
    public static boolean func(int i,int target,int[] arr,Boolean[][] dp){
        if(target==0)return true;
        if(i==0)return target==arr[0];
        
        if(dp[i][target]!=null)return dp[i][target];
        
        boolean take = false;
        if(target>=arr[i])take = func(i-1,target-arr[i],arr,dp);
        
        boolean nottake = func(i-1,target,arr,dp);
        
        return dp[i][target] = take||nottake;
    }
}