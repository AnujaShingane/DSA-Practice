class Pair{
    int[] ij;
    int dist;

    Pair(int[] ij , int dist){
        this.ij = ij;
        this.dist = dist;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        if(grid[0][0]!=0 || grid[n-1][m-1]!=0)return -1;
        q.offer(new Pair(new int[]{0,0},1));

        int[] di = {-1, -1, -1,  0, 0, 1, 1, 1};
        int[] dj = {-1,  0,  1, -1, 1,-1, 0, 1};
        int ndist = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int[] ij = p.ij;
            int i = ij[0];
            int j = ij[1];
            int dist = p.dist;
            if (i == n - 1 && j == m - 1) {
                return dist;
            }

            for(int z = 0 ; z < 8 ; z++){
                int ni = i+di[z];
                int nj = j+dj[z];
                if(ni<0 || ni>=n || nj<0 || nj>=m)continue;
                if(grid[ni][nj]!=0)continue;
                ndist = dist+1;

                grid[ni][nj]=ndist;
                q.offer(new Pair(new int[]{ni,nj},ndist));
            } 
        }

        return -1;
    }
}