class Solution {
    int ans = 0;
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr,-(int)(1e9));
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                func(i,j,matrix,dp);
            }
        }

        return ans*ans;
    }

    public int func(int row,int col,char[][] matrix,int[][] dp) {
        if(row>=matrix.length || col>=matrix[0].length)return 0;
        if(dp[row][col]!=-(int)(1e9))return dp[row][col];

        if(matrix[row][col]=='0')return 0;

        int right = func(row,col+1,matrix,dp);
        int down = func(row+1,col,matrix,dp);
        int diag = func(row+1,col+1,matrix,dp);

        int min = 1 + Math.min(right,Math.min(down,diag));

        ans = Math.max(ans,min);

        return dp[row][col] = min;
    }
}