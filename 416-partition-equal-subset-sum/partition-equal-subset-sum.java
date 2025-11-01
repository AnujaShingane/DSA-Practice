class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum+=nums[i];
        }

        if(sum % 2 != 0)return false;

        int[][] dp = new int[n][(sum/2)+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(n-1, sum/2,nums,dp);
    }

    public boolean func(int ind,int target,int[] nums, int[][] dp){
        if(target==0)return true;
        if(ind==0)return (nums[0]==target);

        if(dp[ind][target]!=-1)return (dp[ind][target]==1);

        boolean nottake = func(ind-1,target,nums,dp);
        boolean take = false;
        if(nums[ind] <= target){
            take = func(ind-1,target-nums[ind],nums,dp);
        }

        dp[ind][target] = (take || nottake)?1:0;
        return dp[ind][target]==1;
    }
}