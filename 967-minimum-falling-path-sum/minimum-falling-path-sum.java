class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr : dp)Arrays.fill(arr,(int)(1e9));

        for(int i = 0 ; i < m ; i++){
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i - 1][j];
                int left = matrix[i][j] + (j > 0 ? dp[i - 1][j - 1] : (int)(1e9));
                int right = matrix[i][j] + (j + 1 < n ? dp[i - 1][j + 1] : (int)(1e9));

                dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            ans = Math.min(ans,dp[n-1][i]);
        }

        return ans;
    }

    public int func(int row,int col,int[][] matrix,int[][] dp) {
        int n = matrix.length;
        int m = matrix[0].length;

        if(col<0 || col>=m)return (int)(1e9);
        if(row==n-1)return matrix[row][col];
        if(dp[row][col]!=(int)(1e9))return dp[row][col];
        
        int down = matrix[row][col] + func(row+1,col,matrix,dp);
        int left =matrix[row][col] + func(row+1,col-1,matrix,dp);
        int right = matrix[row][col] + func(row+1,col+1,matrix,dp);

        return dp[row][col] = Math.min(down,Math.min(left,right));
    }
}