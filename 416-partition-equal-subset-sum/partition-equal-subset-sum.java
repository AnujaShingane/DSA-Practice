class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i = 0 ; i < n ; i++){
            sum+=nums[i];
        }
        if(sum%2!=0)return false;
        int target = sum/2;

        Boolean[][] dp = new Boolean[n][target+1];

        return func(n-1,target,nums,dp);
    }

    public boolean func(int i,int target,int[] nums,Boolean[][] dp){
        if(target==0)return true;
        if(i==0)return target==nums[0];

        if(dp[i][target]!=null)return dp[i][target];

        boolean take = false;
        if(target>=nums[i])take=func(i-1,target-nums[i],nums,dp);

        boolean nottake = func(i-1,target,nums,dp);

        return dp[i][target]=take || nottake;
    }
}