class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr : dp)Arrays.fill(arr,(int)(1e9));

        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            ans = Math.min(ans,func(0,i,matrix,dp));
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