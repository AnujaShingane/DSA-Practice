class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, (int)(1e9));
        }

        return func(m-1,n-1,grid,dp);
    }

    public int func(int row,int col,int[][] grid,int[][] dp) {
        if(row<0 || col<0)return (int)(1e9);
        if(row==0 && col==0)return grid[0][0];
        if(dp[row][col]!=(int)(1e9))return dp[row][col];

        int down = grid[row][col] + func(row-1,col,grid,dp);
        int right = grid[row][col] + func(row,col-1,grid,dp);

        return dp[row][col] = Math.min(down,right);
    }
}