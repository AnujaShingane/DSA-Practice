class Solution {
    public int countPartitions(int[] nums, int diff) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums){
            sum+=ele;
        }
        
        if ((diff + sum) % 2 != 0 || Math.abs(diff) > sum) {
            return 0;
        }
        
        int target = (diff + sum)/2;
        int[][] dp = new int[n][target+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        
        return func(n-1,nums,target,dp);
    }
    
    public int func(int ind,int[] nums,int target,int[][] dp) {
        if(ind==0){
            if(target==0 && nums[0]==0)return 2;
            if(target==0 || nums[0]==target) return 1;
            else return 0;
        }
        
        if(dp[ind][target]!=-1)return dp[ind][target];

        int nottake = func(ind-1,nums,target,dp);
        int take = 0;
        if(target>=nums[ind])take = func(ind-1,nums,target-nums[ind],dp);

        return dp[ind][target] = take + nottake;
    }
}
