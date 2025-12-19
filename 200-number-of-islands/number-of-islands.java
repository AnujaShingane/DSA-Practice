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
                    bfs(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }

    public void bfs(int i, int j, boolean[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        vis[i][j] = true;

        while (!q.isEmpty()) {
            Pair rem = q.poll();
            int row = rem.row;
            int col = rem.col;

            // UP
            if (row - 1 >= 0 &&
                grid[row - 1][col] == '1' &&
                vis[row - 1][col] == false) {

                vis[row - 1][col] = true;
                q.add(new Pair(row - 1, col));
            }

            // DOWN
            if (row + 1 < n &&
                grid[row + 1][col] == '1' &&
                vis[row + 1][col] == false) {

                vis[row + 1][col] = true;
                q.add(new Pair(row + 1, col));
            }

            // LEFT
            if (col - 1 >= 0 &&
                grid[row][col - 1] == '1' &&
                vis[row][col - 1] == false) {

                vis[row][col - 1] = true;
                q.add(new Pair(row, col - 1));
            }

            // RIGHT
            if (col + 1 < m &&
                grid[row][col + 1] == '1' &&
                vis[row][col + 1] == false) {

                vis[row][col + 1] = true;
                q.add(new Pair(row, col + 1));
            }
        }
    }
}
