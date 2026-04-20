class Solution {
    int[][] h;
    boolean pacific;
    boolean atlantic;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        h = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                h[i][j] = heights[i][j];
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                pacific = false;
                atlantic = false;

                boolean[][] vis = new boolean[n][m];

                dfs(i,j,n,m,h[i][j],vis,h);

                if(pacific && atlantic){
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
    }

    public void dfs(int i,int j,int n,int m,int num,boolean[][] vis,int[][] h){
        if(i<0 || j<0){
            pacific = true;
            return;
        }

        if(i>=n || j>=m){
            atlantic = true;
            return;
        }

        if(vis[i][j] || h[i][j]>num)return;

        vis[i][j] = true;

        dfs(i-1,j,n,m,h[i][j],vis,h);
        dfs(i,j-1,n,m,h[i][j],vis,h);
        dfs(i,j+1,n,m,h[i][j],vis,h);
        dfs(i+1,j,n,m,h[i][j],vis,h);
    }
}