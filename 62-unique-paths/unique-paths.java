class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(m-1,n-1,dp,m,n);
    }

    public int func(int i,int j,int[][] dp,int m , int n) {
        if(i<0 || i>=m || j<0 || j>=n)return 0;
        if(i==0 && j==0)return 1;
        if(dp[i][j]!=-1)return dp[i][j];

        int left = func(i,j-1,dp,m,n);
        int top = func(i-1,j,dp,m,n);

        return dp[i][j] = left+top;
    }
}