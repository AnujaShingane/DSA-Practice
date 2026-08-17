class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) dp[0][j] = matrix[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i - 1][j];
                int left = matrix[i][j] + (j > 0 ? dp[i - 1][j - 1] : (int)(1e9));
                int right = matrix[i][j] + (j + 1 < n ? dp[i - 1][j + 1] : (int)(1e9));

                dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) ans = Math.min(ans, dp[n - 1][j]);

        return ans;
    }
}