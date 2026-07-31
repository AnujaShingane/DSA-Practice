class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return func(m-1,n-1,dp);
    }

    public int func(int row,int col,int[][] dp) {
        if(row<0 || col<0)return 0;
        if(row==0 && col==0)return 1;
        if(dp[row][col]!=-1)return dp[row][col];

        int up = func(row-1,col,dp);
        int down = func(row,col-1,dp);

        return dp[row][col] = up+down;
    }
}