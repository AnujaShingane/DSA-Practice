import java.util.*;

class Pair {
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    // Needed for HashSet comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair p = (Pair) o;
        return i == p.i && j == p.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}

class Solution {
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Set<ArrayList<Pair>> set = new HashSet<>();
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    bfs(n, m, i, j, vis, grid, set);
                }
            }
        }
        return set.size();
    }

    public void bfs(int n, int m, int bi, int bj,
                    boolean[][] vis, int[][] grid,
                    Set<ArrayList<Pair>> set) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(bi, bj));
        vis[bi][bj] = true;

        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};

        ArrayList<Pair> list = new ArrayList<>();
        list.add(new Pair(0, 0)); // base cell (relative)

        while (!q.isEmpty()) {
            Pair rem = q.poll();
            int row = rem.i;
            int col = rem.j;

            for (int r = 0; r < 4; r++) {
                int nr = row + delr[r];
                int nc = col + delc[r];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    grid[nr][nc] == 1 && !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));

                    // store RELATIVE coordinates
                    list.add(new Pair(nr - bi, nc - bj));
                }
            }
        }

        set.add(list); // add AFTER BFS completes
    }
}
