class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        //hori boundries
        for(int i = 0 ; i < m ; i++){
            if(board[0][i] == 'O'){
                vis[0][i] = true;
                bfs(n,m,0,i,vis,board); // here mark all vis
            }

            if(board[n-1][i] == 'O'){
                vis[n-1][i] = true;
                bfs(n,m,n-1,i,vis,board); // here mark all vis
            }
        }

        //vert boundries
        for(int i = 0 ; i < n ; i++){
            if(board[i][0] == 'O'){
                vis[i][0] = true;
                bfs(n,m,i,0,vis,board); // here mark all vis
            }

            if(board[i][m-1] == 'O'){
                vis[i][m-1] = true;
                bfs(n,m,i,m-1,vis,board); // here mark all vis
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] =='O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(int n, int m, int i, int j, boolean[][] vis, char[][] board) {
    int[] delr = {-1, 0, 1, 0};
    int[] delc = {0, 1, 0, -1};

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{i, j});

    while (!q.isEmpty()) {
        int[] cur = q.poll();
        int row = cur[0];
        int col = cur[1];

        for (int r = 0; r < 4; r++) {
            int nr = row + delr[r];
            int nc = col + delc[r];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                board[nr][nc] == 'O' && !vis[nr][nc]) {

                vis[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}

}