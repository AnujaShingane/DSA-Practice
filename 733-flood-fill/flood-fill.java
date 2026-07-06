class Solution {
    int startingcolor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] res = new int[n][m];
        startingcolor = image[sr][sc];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                res[i][j] = image[i][j];
            }
        }

        dfs(sr,sc,n,m,color,vis,res);

        return res;
    }

    public void dfs(int sr,int sc,int n, int m,int color,boolean[][] vis, int[][] res) {
        if(sr>=n || sr<0 || sc>=m || sc<0 || vis[sr][sc] || res[sr][sc]!=startingcolor) return;

        vis[sr][sc] = true;
        res[sr][sc] = color;

        dfs(sr+1,sc,n,m,color,vis,res);
        dfs(sr,sc-1,n,m,color,vis,res);
        dfs(sr-1,sc,n,m,color,vis,res);
        dfs(sr,sc+1,n,m,color,vis,res);
    }
}