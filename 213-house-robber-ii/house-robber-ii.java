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

        dp[0] = nums.get(0);

        for(int i = 1 ; i < n ; i++){
            int pick = nums.get(i);
            if(i>1)pick = nums.get(i) + dp[i-2];
            int notpick = dp[i-1];

            dp[i] = Math.max(pick,notpick);
        }

        return dp[n-1];
    }
}