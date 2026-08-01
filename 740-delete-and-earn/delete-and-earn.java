class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int num : nums){
            max = Math.max(num,max);
        }

        int[] points = new int[max+1];

        for(int num : nums){
            points[num] += num;
        }

        int[] dp = new int[max+1];
        Arrays.fill(dp,-(int)(1e9));

        return func(points.length-1,points,dp);
    }

    public int func(int ind,int[] points,int[] dp) {
        if(ind<0)return 0;
        if(dp[ind]!=-(int)(1e9))return dp[ind];

        int take = points[ind] + func(ind-2,points,dp);
        int nottake = func(ind-1,points,dp);

        return dp[ind] = Math.max(take,nottake);
    }
}