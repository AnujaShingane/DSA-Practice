class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums)sum+=ele;
        if(sum%2!=0)return false;
        int target = sum/2;
        boolean[][] dp = new boolean[n][sum+1];

        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true;
        }

        if(target>=nums[0])dp[0][nums[0]] = true;

        for(int ind = 1 ; ind < n ; ind++){
            for(int t = 0 ; t <= sum ; t++){
                boolean nottake = dp[ind-1][t];
                boolean take = false;
                if(nums[ind]<= t)take = dp[ind-1][t-nums[ind]];

                dp[ind][t] = take || nottake;
            }
        }

        return dp[n-1][target];
    }
}