class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        int n = grid.length;
        int m = grid[0].length;

        // If source or destination is blocked
        if (grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0)
            return -1;

        // Distance array
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], -1);

        // BFS queue
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{source[0], source[1]});
        dist[source[0]][source[1]] = 0;

        // Directions: Left, Up, Right, Down
        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            // If destination reached
            if (r == destination[0] && c == destination[1])
                return dist[r][c];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m &&
                    grid[nr][nc] == 1 && dist[nr][nc] == -1) {

                    dist[nr][nc] = dist[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}
