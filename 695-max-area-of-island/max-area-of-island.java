class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==1)ans = Math.max(ans,dfs(grid,i,j));
            }
        }

        return ans;
    }

    public int dfs(int[][] grid,int r,int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length){
            return 0;
        }

        if(grid[r][c]==0 || grid[r][c]==-1){
            return 0;
        }

        grid[r][c]=-1;

        return 1+dfs(grid,r+1,c)+dfs(grid,r-1,c)+dfs(grid,r,c+1)+dfs(grid,r,c-1);
    }
}