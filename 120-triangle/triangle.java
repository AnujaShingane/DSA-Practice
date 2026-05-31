class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int[][] dp = new int[n+1][m+1];

        for(int j = 0 ; j < m ; j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2 ; i >= 0 ; i--){
            for(int j = 0 ; j <= i ; j++){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diag = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(down,diag);
            }
        }

        return dp[0][0];
    }
}