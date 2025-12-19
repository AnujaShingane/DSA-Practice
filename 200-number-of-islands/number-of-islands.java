class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && vis[i][j] == false) {
                    cnt++;
                    bfs(n, m, i, j, vis, grid);
                }
            }
        }
        return cnt;
    }

    public void bfs(int n, int m, int i, int j, boolean[][] vis, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        vis[i][j] = true;

        while (!q.isEmpty()) {
            Pair rem = q.poll();
            int row = rem.row;
            int col = rem.col;

            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {

                    // ❌ skip diagonals and self
                    if (Math.abs(delrow) + Math.abs(delcol) != 1) continue;

                    int nrow = row + delrow;
                    int ncol = col + delcol;

                    if (nrow >= 0 && nrow < n &&
                        ncol >= 0 && ncol < m &&
                        vis[nrow][ncol] == false &&
                        grid[nrow][ncol] == '1') {

                        vis[nrow][ncol] = true;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
}
