class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for(int i = 0 ; i < n-1 ; i++){
            arr1.add(nums[i]);
        }
        for(int i = 1 ; i < n ; i++){
            arr2.add(nums[i]);
        }

        int[] dp1 = new int[n];
		Arrays.fill(dp1,-(int)(1e9));
        int[] dp2 = new int[n];
		Arrays.fill(dp2,-(int)(1e9));

        return Math.max(func(arr1.size()-1,arr1,dp1),func(arr2.size()-1,arr2,dp2));
    }

    public static int func(int ind,ArrayList<Integer> nums,int[] dp) {
		if(ind<0)return 0;
		if(dp[ind]!=-(int)(1e9))return dp[ind];

		int take = nums.get(ind) + func(ind-2,nums,dp);
		int nottake = func(ind-1,nums,dp);

		return dp[ind] = Math.max(take,nottake);
	}
}