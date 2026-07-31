class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return func(m-1,n-1,obstacleGrid,dp);
    }

    public int func(int row,int col,int[][] obstacleGrid,int[][] dp) {
        if(row<0 || col<0 || obstacleGrid[row][col]==1)return 0;
        if(row==0 && col==0)return 1;
        if(dp[row][col]!=-1)return dp[row][col];

        int up = func(row-1,col,obstacleGrid,dp);
        int down = func(row,col-1,obstacleGrid,dp);

        return dp[row][col] = up+down;
    }
}