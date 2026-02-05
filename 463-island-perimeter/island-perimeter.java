class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==1)return dfs(grid,i,j);
            }
        }

        return 0;
    }

    public int dfs(int[][] grid,int r,int c){
        //reached in water(not 0 but out of grid) - add 1 for water boundary
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length){
            return 1;
        }

        //inside grid reached water add 1
        if(grid[r][c]==0)return 1;

        //if vis don't add anything to perimeter
        if(grid[r][c]==-1){
            return 0;
        }

        grid[r][c] = -1;

        return dfs(grid,r+1,c)+dfs(grid,r-1,c)+dfs(grid,r,c+1)+dfs(grid,r,c-1);
    }
}