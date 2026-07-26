class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int ind = n-1 ; ind >= 0 ; ind--){
            for(int prev = ind-1 ; prev >= -1 ; prev--){
                int nottake = dp[ind+1][prev+1];
                int take = 0;
                if(prev==-1 || nums[ind]>nums[prev]){
                    take = 1 + dp[ind+1][ind+1];
                }

                dp[ind][prev+1] = Math.max(take,nottake);
            }
        }

        return dp[0][0];
    }

    public int func(int ind,int prev,int[] nums,int[][] dp) {
        if(ind==nums.length)return 0;
        if(dp[ind][prev+1]!=-1)return dp[ind][prev+1];

        int nottake = func(ind+1,prev,nums,dp);
        int take = 0;
        if(prev==-1 || nums[ind]>nums[prev]){
            take = 1 + func(ind+1,ind,nums,dp);
        }

        return dp[ind][prev+1] = Math.max(take,nottake);
    }
}