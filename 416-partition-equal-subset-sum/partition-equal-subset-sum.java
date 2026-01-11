class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i = 0 ; i < n ; i++){
            sum+=nums[i];
        }
        if(sum%2!=0)return false;
        int target = sum/2;

        boolean[][] dp = new boolean[n][target+1];

        if(target>=nums[0])dp[0][nums[0]]=true;
        for(int i = 0 ; i < n ; i++)dp[i][0]=true;

        for(int i = 1 ; i < n ; i++){
            for(int tar = 1 ; tar <= target ; tar++){
                boolean take = false;
                if(tar>=nums[i])take=dp[i-1][tar-nums[i]];

                boolean nottake = dp[i-1][tar];

                dp[i][tar]=take || nottake;
            }
        }

        return dp[n-1][target];
    }

    // public boolean func(int i,int target,int[] nums,Boolean[][] dp){
    //     if(target==0)return true;//dp[i][0]=true
    //     if(i==0)return target==nums[0];//dp[0][nums[0]]=true

    //     if(dp[i][target]!=null)return dp[i][target];

    //     boolean take = false;
    //     if(target>=nums[i])take=func(i-1,target-nums[i],nums,dp);

    //     boolean nottake = func(i-1,target,nums,dp);

    //     return dp[i][target]=take || nottake;
    // }
}