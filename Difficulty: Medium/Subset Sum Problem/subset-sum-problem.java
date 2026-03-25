class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        return f(n-1,sum,arr,dp);
    }
    
    public static boolean f(int ind,int target,int[] arr,Boolean[][] dp){
        if(target==0)return true;
        if(ind==0)return arr[0]==target;
        
        if(dp[ind][target]!=null)return dp[ind][target];
        
        boolean nottake = f(ind-1,target,arr,dp);
        boolean take = false;
        if(target>=arr[ind])take = f(ind-1,target-arr[ind],arr,dp);
        
        return dp[ind][target] = take || nottake;
    }
}