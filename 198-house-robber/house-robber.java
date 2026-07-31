class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp,-(int)(1e9));

		return func(n-1,nums,dp);
    }

    public static int func(int ind,int[] nums,int[] dp) {
		if(ind<0)return 0;
		if(dp[ind]!=-(int)(1e9))return dp[ind];

		int take = nums[ind] + func(ind-2,nums,dp);
		int nottake = func(ind-1,nums,dp);

		return dp[ind] = Math.max(take,nottake);
	}
}