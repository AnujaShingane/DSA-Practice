class Solution {
    public static int mod = (int)(1e9+7);
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int[] arr : dp)Arrays.fill(arr,-1);
        
        return func(n-1,nums,target,dp);
    }
    
    public int func(int i,int[] nums,int target,int[][] dp){
        if(i<0){
            if(target==0)return 1;
            else return 0;
        }
        
        if(dp[i][target]!=-1)return dp[i][target];
        
        int take = 0;
        if(target>=nums[i])take = func(i-1,nums,target-nums[i],dp);
        
        int nottake = func(i-1,nums,target,dp);
        
        return dp[i][target]=((take)%mod+(nottake)%mod)%mod;
    }
}