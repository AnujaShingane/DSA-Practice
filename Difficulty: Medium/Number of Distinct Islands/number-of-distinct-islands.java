class Solution {
    public int countDistinctIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && grid[i][j] == 'L'){
                    StringBuilder sb = new StringBuilder();
                    dfs(i,j,i,j,n,m,sb,vis,grid);
                    set.add(sb.toString());
                }
            }
        }
        
        return set.size();
    }
    
    public void dfs(int row,int col,int baserow, int basecol, int n, int m, StringBuilder sb, boolean[][] vis,char[][] grid) {
        if(row >= n || row < 0 || col >= m || col < 0 || vis[row][col] || grid[row][col] != 'L') return;
        
        vis[row][col] = true;
        sb.append(row-baserow).append(",").append(col-basecol).append("|");
        
        dfs(row+1,col,baserow,basecol,n,m,sb,vis,grid);
        dfs(row,col-1,baserow,basecol,n,m,sb,vis,grid);
        dfs(row-1,col,baserow,basecol,n,m,sb,vis,grid);
        dfs(row,col+1,baserow,basecol,n,m,sb,vis,grid);
    }
}