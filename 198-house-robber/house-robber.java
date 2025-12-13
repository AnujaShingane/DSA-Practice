class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return func(n-1,nums,dp);
    }

    public int func(int ind, int[] nums,int[] dp){
        if(ind<0)return 0;
        if(ind==0)return nums[0];
        if(dp[ind]!=-1)return dp[ind];

        int take = nums[ind]+func(ind-2,nums,dp);
        int nottake = func(ind-1,nums,dp);

        return dp[ind]=Math.max(take,nottake);
    }
}