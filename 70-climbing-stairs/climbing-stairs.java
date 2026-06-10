class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return func(n,dp);
    }

    public int func(int ind,int[] dp) {
        if(ind==0)return 1;
        if(ind<0)return 0;
        if(dp[ind]!=-1)return dp[ind];

        int one = func(ind-1,dp);
        int two = 0;
        if(ind>1) two = func(ind-2,dp);

        return dp[ind] = one + two;
    }
}