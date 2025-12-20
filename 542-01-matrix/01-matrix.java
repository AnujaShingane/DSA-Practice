import java.util.*;

class Pair {
    int i, j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class PairDist {
    Pair p;
    int dist;
    PairDist(Pair p, int dist) {
        this.p = p;
        this.dist = dist;
    }
}


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<PairDist> q = new LinkedList<>();

        int[][] ans = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                ans[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    vis[i][j] = true;
                    q.add(new PairDist(new Pair(i, j), 0));
                    ans[i][j]= 0;
                }
            }
        }

        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            PairDist pd = q.poll();
            int row = pd.p.i;
            int col = pd.p.j;
            int dist = pd.dist;

            for (int k = 0; k < 4; k++) {
                int dr = row + delr[k];
                int dc = col + delc[k];

                if (dr >= 0 && dr < n && dc >= 0 && dc < m &&
                    !vis[dr][dc] && mat[dr][dc] == 1) {

                    vis[dr][dc] = true;
                    ans[dr][dc] =dist + 1;
                    q.add(new PairDist(new Pair(dr, dc), dist + 1));
                }
            }
        }

        return ans;
    }
}