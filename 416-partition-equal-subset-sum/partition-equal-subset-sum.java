class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums)sum+=ele;
        if(sum%2!=0)return false;
        int target = sum/2;
        Boolean[][] dp = new Boolean[n][sum+1];

        return func(n-1,nums,target,dp);
    }

    public boolean func(int ind,int[] nums,int target,Boolean[][] dp){
        if(target==0)return true;
        if(ind==0){
            return nums[0] == target;
        }

        if(dp[ind][target]!=null)return dp[ind][target];

        boolean nottake = func(ind-1,nums,target,dp);
        boolean take = false;
        if(nums[ind]<= target)take = func(ind-1,nums,target-nums[ind],dp);

        return dp[ind][target] = take || nottake;
    }
}