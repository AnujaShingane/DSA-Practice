class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;


        //2
        for(int i = 0 ; i < m ; i++){
            if(board[0][i]=='O'){
                dfs(board,0,i);
            }
            if(board[n-1][i]=='O'){
                dfs(board,n-1,i);
            }
        }

        for(int j = 0 ; j < n ; j++){
            if(board[j][0]=='O'){
                dfs(board,j,0);
            }
            if(board[j][m-1]=='O'){
                dfs(board,j,m-1);
            }
        }


        for(int a = 0 ; a < n ; a++){
            for(int b = 0 ; b < m ; b++){
                if(board[a][b]=='O')board[a][b]='X';
                if(board[a][b]=='2')board[a][b]='O';
            }
        }
    }

    public void dfs(char[][] board , int r , int c){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length){
            return;
        }

        if(board[r][c]=='X' || board[r][c]=='2'){
            return;
        }

        board[r][c]='2';

        dfs(board,r+1,c);
        dfs(board,r,c+1);
        dfs(board,r-1,c);
        dfs(board,r,c-1);
    }
}