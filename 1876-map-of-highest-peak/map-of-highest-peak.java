class Pair{
    int i;
    int j;
    int dis;
    
    Pair(int i, int j , int dis){
        this.i = i;
        this.j = j;
        this.dis = dis;
    }
}

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int[][] dist = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(isWater[i][j]==1){
                    vis[i][j]=true;
                    dist[i][j]=0;
                    q.offer(new Pair(i,j,0));
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.i;
            int c = p.j;
            int wt = p.dis;

            for(int i = 0 ; i < 4 ; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                int newWt = wt+1;

                if(nr<0 || nr>=n || nc<0 || nc>=m || vis[nr][nc])continue;

                vis[nr][nc]=true;
                dist[nr][nc] = newWt;
                q.offer(new Pair(nr,nc,newWt));
            }
        }

        return dist;
    }
}