class Pair{
    int i;
    int j;

    Pair(int i , int j ){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];

        int prevColor = image[sr][sc];
        if (prevColor == color) return image; // important

        bfs(n,m,sr,sc,prevColor,color,image,vis);
        return image;
    }

    public void bfs(int n , int m,int sr, int sc, int prevColor,int color,int[][] image,boolean[][] vis){
        int prevcol = image[sr][sc];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        vis[sr][sc] = true;
        image[sr][sc] = color;
        int[] delrow = {0,-1,0,1};
        int[] delcol = {-1,0,1,0};

        while(!q.isEmpty()){
            Pair rem = q.poll();
            int r = rem.i;
            int c = rem.j;

            for(int k = 0 ; k < 4 ; k++){
                int nr = r+delrow[k];
                int nc = c+delcol[k];
                    
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==false && image[nr][nc]==prevcol){
                    vis[nr][nc]=true;
                    image[nr][nc]=color;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
}