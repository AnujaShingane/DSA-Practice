class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        return func(n-1,m-1,grid,dp);
    }

    public int func(int i,int j,int[][] grid,int[][] dp) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)return (int)1e9;
        if(i==0 && j==0)return grid[i][j];
        if(dp[i][j] != Integer.MAX_VALUE)return dp[i][j];

        int top = grid[i][j] + func(i-1,j,grid,dp);
        int left = grid[i][j] + func(i,j-1,grid,dp);
        
        return dp[i][j] = Math.min(top,left);
    }
}