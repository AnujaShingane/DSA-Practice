class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        if(n*m<word.length())return false;

        if(n==1 && m==1){
            if(word.charAt(0)==board[0][0])return true;
            else return false;
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(i,j,0,word,vis,board))return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int i,int j,int ind,String word,boolean[][] vis,char[][] board) {
        int n = board.length;
        int m = board[0].length;
        if(ind==word.length())return true;

        if(vis[i][j])return false;

        if(board[i][j]!=word.charAt(ind))return false;

        vis[i][j] = true;

        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        for(int k = 0 ; k < 4 ; k++){
            int row = i + di[k];
            int col = j + dj[k];

            if(row<0 || row>=n || col < 0 || col>=m)continue;

            if(dfs(row,col,ind+1,word,vis,board)){
                return true;
            }
        }

        vis[i][j] = false;
        return false;
    }
}