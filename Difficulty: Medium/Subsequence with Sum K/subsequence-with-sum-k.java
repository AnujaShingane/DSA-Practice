class Solution {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][k+1];
        
        return func(n-1,arr,k,dp);
    }
    
    public boolean func(int ind,int[] arr,int target,Boolean[][] dp) {
        if(target==0){
            return true;
        }
        
        if(ind==0){
            return target==arr[ind];
        }
        
        if(dp[ind][target]!=null)return dp[ind][target];
        
        boolean take = false;
        if(target>=arr[ind]){
            take = func(ind-1,arr,target-arr[ind],dp);
        }
        
        boolean nottake = func(ind-1,arr,target,dp);
        
        return dp[ind][target] = take||nottake;
    }
}