class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        //hori boundries
        for(int i = 0 ; i < m ; i++){
            if(grid[0][i] == 1){
                vis[0][i] = true;
                bfs(n,m,0,i,vis,grid); // here mark all vis
            }

            if(grid[n-1][i] == 1){
                vis[n-1][i] = true;
                bfs(n,m,n-1,i,vis,grid); // here mark all vis
            }
        }

        //vert boundries
        for(int i = 0 ; i < n ; i++){
            if(grid[i][0] == 1){
                vis[i][0] = true;
                bfs(n,m,i,0,vis,grid); // here mark all vis
            }

            if(grid[i][m-1] == 1){
                vis[i][m-1] = true;
                bfs(n,m,i,m-1,vis,grid); // here mark all vis
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void bfs(int n,int m,int i,int j,boolean[][] vis,int[][] grid){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});

        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] rem = q.poll();
            int row = rem[0];
            int col = rem[1];

            for(int r = 0 ; r < 4 ; r++){
                int nr = row + delr[r];
                int nc = col + delc[r];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    grid[nr][nc] == 1 && !vis[nr][nc]) {
                    
                    vis[nr][nc]=true;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
}