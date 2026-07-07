class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            if(!vis[i][0] && board[i][0] == 'O'){
                dfs(i,0,n,m,vis,board);
            }
        }

        for(int i = 0 ; i < m ; i++){
            if(!vis[0][i] && board[0][i] == 'O'){
                dfs(0,i,n,m,vis,board);
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(!vis[i][m-1] && board[i][m-1] == 'O'){
                dfs(i,m-1,n,m,vis,board);
            }
        }

        for(int i = 0 ; i < m ; i++){
            if(!vis[n-1][i] && board[n-1][i] == 'O'){
                dfs(n-1,i,n,m,vis,board);
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                if(board[i][j]=='|')board[i][j] = 'O';
            }
        }
    }

    public void dfs(int row,int col,int n, int m, boolean[][] vis,char[][] board) {
        if(row >= n || row < 0 || col >= m || col < 0 || vis[row][col] || board[row][col] != 'O') return;
        
        vis[row][col] = true;
        board[row][col] = '|';

        dfs(row+1,col,n,m,vis,board);
        dfs(row,col-1,n,m,vis,board);
        dfs(row-1,col,n,m,vis,board);
        dfs(row,col+1,n,m,vis,board);
    }
}