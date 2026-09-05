class Pair{
    int i;
    int j;
    int dis;

    Pair(int i , int j , int dis){
        this.i = i;
        this.j = j;
        this.dis = dis;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];
        for(int[] arr : ans){
            Arrays.fill(arr,0);
        }

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j,0));
                }
            }
        }

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.i;
            int c = p.j;
            int dist = p.dis;

            for(int z = 0 ; z < 4 ; z++){
                int nr = r + dr[z];
                int nc = c + dc[z];
                int ndis = dist + 1;

                if(nr<0 || nr>=n || nc<0 || nc>=m || vis[nr][nc] || mat[nr][nc]!=1)continue;

                vis[nr][nc] = true;
                ans[nr][nc] = ndis;
                q.offer(new Pair(nr,nc,ndis));
            }
        }

        return ans;
    }
}