class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] res = new int[n][m];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                res[i][j] = image[i][j];
            }
        }

        int num = res[sr][sc];
        if(num == color)return res;

        dfs(sr,sc,n,m,num,res,color);

        return res;
    }

    public void dfs(int i,int j,int n,int m,int num, int[][] res, int color){
        if(i<0 || i>=n || j<0 || j>=m || res[i][j] != num)return;

        res[i][j] = color;

        dfs(i-1,j,n,m,num,res,color);
        dfs(i,j-1,n,m,num,res,color);
        dfs(i,j+1,n,m,num,res,color);
        dfs(i+1,j,n,m,num,res,color);
    }
}