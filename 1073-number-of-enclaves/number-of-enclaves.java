class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            if(grid[i][0]==1)dfs(i,0,n,m,vis,grid);
        }

        for(int i = 0 ; i < m ; i++){
            if(grid[0][i]==1)dfs(0,i,n,m,vis,grid);
        }

        for(int i = 0 ; i < n ; i++){
            if(grid[i][m-1]==1)dfs(i,m-1,n,m,vis,grid);
        }

        for(int i = 0 ; i < m ; i++){
            if(grid[n-1][i]==1)dfs(n-1,i,n,m,vis,grid);
        }

        int cnt = 0;
        for(int[] arr : grid){
            for(int num : arr){
                if(num==1)cnt++;
            }
        }

        return cnt;
    }

    public void dfs(int row,int col,int n,int m,boolean[][] vis,int[][] grid) {
        if(row >= n || row < 0 || col >= m || col < 0 || vis[row][col] || grid[row][col] != 1) return;

        vis[row][col] = true;
        grid[row][col] = 2;

        dfs(row+1,col,n,m,vis,grid);
        dfs(row,col-1,n,m,vis,grid);
        dfs(row-1,col,n,m,vis,grid);
        dfs(row,col+1,n,m,vis,grid);
    }
}