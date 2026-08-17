class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        
        dp[0][0] = grid[0][0];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i==0 && j==0)continue;

                int up = grid[i][j] + ((i>=1) ? dp[i - 1][j] : (int)(1e9));
                int left = grid[i][j] + ((j>=1) ? dp[i][j-1] : (int)(1e9));

                dp[i][j] = Math.min(up,left);
            }
        }
        
        return dp[n-1][m-1];
    }

    public int func(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) return grid[0][0];
        if (i < 0 || j < 0) return (int)(1e9);
        if (dp[i][j] != (int)(1e9)) return dp[i][j];

        int up = grid[i][j] + func(i - 1, j, grid, dp);
        int left = grid[i][j] + func(i, j - 1, grid, dp);

        return dp[i][j] = Math.min(up,left);
    }
}