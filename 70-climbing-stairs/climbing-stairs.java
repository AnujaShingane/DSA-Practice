class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return func(n, dp);
    }

    public int func(int ind, int[] dp) {
        if (ind == 0) return 1;
        if (ind == 1) return 1;
        if (dp[ind] != -1) return dp[ind];
        
        return dp[ind] = func(ind - 1, dp) + func(ind - 2, dp);
    }
}
