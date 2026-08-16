class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];
        for(int[][] mat : dp){
            for(int[] arr : mat){
                Arrays.fill(arr,Integer.MIN_VALUE);
            }
        }

        return func(0,0,m-1,grid,dp);
    }

    public int func(int r,int c1,int c2,int[][] grid,int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;

        if(c1<0 || c1>=m || c2<0 || c2>=m)return Integer.MIN_VALUE;
        if(r==n-1)return grid[r][c1] + ((c1==c2) ? 0 : grid[r][c2]);
        if(dp[r][c1][c2]!=Integer.MIN_VALUE)return dp[r][c1][c2];

        int ans = Integer.MIN_VALUE;
        for(int d1 = -1 ; d1 <= 1 ; d1++){
            for(int d2 = -1 ; d2 <= 1 ; d2++){
                ans = Math.max(ans,func(r+1,c1+d1,c2+d2,grid,dp));
            }
        }

        int curr = grid[r][c1] + ((c1==c2) ? 0 : grid[r][c2]);
        return dp[r][c1][c2] = curr+ans;
    }
}