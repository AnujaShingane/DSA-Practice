class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        ArrayList<Integer> nums1 = new ArrayList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            if(i!=0)nums1.add(nums[i]);
            if(i!=n-1)nums2.add(nums[i]);
        }

        return Math.max(ans(nums1),ans(nums2));
    }

    public int ans(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return func(n-1,nums,dp);
    }

    public int func(int ind,ArrayList<Integer> nums,int[] dp) {
        if(ind==0)return nums.get(0);
        if(ind<0)return 0;

        if(dp[ind]!=-1)return dp[ind];

        int pick = nums.get(ind) + func(ind-2,nums,dp);
        int notpick = func(ind-1,nums,dp);

        return dp[ind] = Math.max(pick,notpick);
    }
}