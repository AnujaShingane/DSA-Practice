class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum1 = 0;

        for(int i = 0 ; i < n ; i++){
            sum1 += nums[i];
        }

        if(sum1%2 != 0)return false;

        int sum = sum1/2;

        Boolean[][] dp = new Boolean[n][sum+1];
        
        return func(n-1,nums,sum,dp);
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