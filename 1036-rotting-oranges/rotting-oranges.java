class Pair{
    int i, j;

    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        int min = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(grid[i][j] == 2)
                    q.offer(new Pair(i,j));

                else if(grid[i][j] == 1)
                    fresh++;
            }
        }

        int[] di = {-1,0,1,0};
        int[] dj = {0,1,0,-1};

        while(!q.isEmpty() && fresh > 0){

            int size = q.size();

            while(size-- > 0){

                Pair p = q.poll();

                for(int k = 0; k < 4; k++){

                    int ni = p.i + di[k];
                    int nj = p.j + dj[k];

                    if(ni>=0 && ni<n && nj>=0 && nj<m && grid[ni][nj]==1){

                        grid[ni][nj] = 2; // mark rotten
                        fresh--;

                        q.offer(new Pair(ni,nj));
                    }
                }
            }

            min++;
        }

        return fresh == 0 ? min : -1;
    }
}