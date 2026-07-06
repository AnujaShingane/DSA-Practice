class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    cnt++;
                    dfs(i,j,n,m,vis,grid);
                }
            }
        }

        return cnt;
    }

    public void dfs(int row,int col,int n , int m, boolean[][] vis,char[][] grid) {
        if(row >= n || row < 0 || col >= m || col < 0 || vis[row][col] || grid[row][col]=='0') return;

        vis[row][col] = true;

        dfs(row+1,col,n,m,vis,grid);
        dfs(row,col-1,n,m,vis,grid);
        dfs(row-1,col,n,m,vis,grid);
        dfs(row,col+1,n,m,vis,grid);
    }
}