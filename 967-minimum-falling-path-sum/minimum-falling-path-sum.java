class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr : dp)Arrays.fill(arr,(int)(1e9));

        for(int i = 0 ; i < m ; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int row = 1 ; row < n ; row++){
            for(int col = 0 ; col < m ; col++){
                int up = matrix[row][col] + dp[row-1][col];
                int left = matrix[row][col] + ((col>=1) ? dp[row-1][col-1] : (int)(1e9));
                int right = matrix[row][col] + ((col<m-1) ? dp[row-1][col+1] : (int)(1e9));

                dp[row][col] = Math.min(up,Math.min(left,right));
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