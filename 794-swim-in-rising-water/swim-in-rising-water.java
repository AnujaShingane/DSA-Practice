class Pair{
    int time;
    int row;
    int col;

    Pair(int time, int row ,int col){
        this.time = time;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->a.time-b.time
        );
        boolean[][] vis = new boolean[n][m];
        vis[0][0] =true;
        pq.offer(new Pair(grid[0][0],0,0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int t = p.time;
            int r = p.row;
            int c = p.col;

            if(r==n-1 && c==m-1)return t;

            for(int i = 0 ; i < 4 ; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(nr<0 || nr>=n || nc<0 || nc>=m || vis[nr][nc])continue;
                int nt = Math.max(t,grid[nr][nc]);

                vis[nr][nc] = true;
                pq.offer(new Pair(nt,nr,nc));
            }
        }

        return -1;
    }
}