class Pair{
    int i;
    int j;

    Pair(int i , int j ){
        this.i = i;
        this.j = j;
    }
}

class PairTime{
    Pair p;
    int time;

    PairTime(Pair p,int time){
        this.p = p;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<PairTime> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        for(int ii = 0 ; ii < n ; ii++){
            for(int jj = 0 ; jj < m ; jj++){
                vis[ii][jj] = grid[ii][jj];
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    q.add(new PairTime(new Pair(i,j),0));
                    vis[i][j] = 2;
                }
            }
        }

        int maxt = 0;
        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};

        while(!q.isEmpty()){
            PairTime rem = q.poll();
            Pair p = rem.p;
            int row = p.i;
            int col = p.j;
            int time = rem.time;

            maxt = Math.max(maxt,time);

            for(int i = 0 ; i < 4 ; i++){
                int dr = row + delr[i];
                int dc = col + delc[i];

                if(dr>=0 && dr<n && dc>=0 && dc<m && vis[dr][dc]==1){
                    vis[dr][dc] = 2;
                    q.add(new PairTime(new Pair(dr,dc),time+1));
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(vis[i][j]==1)return -1;
            }
        }
        return maxt;
    }
}