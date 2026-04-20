class Solution {
    int n, m;
    int[][] h;
    boolean pacific, atlantic;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        h = heights;
        n = h.length;
        m = h[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                pacific = false;
                atlantic = false;

                boolean[][] vis = new boolean[n][m];

                dfs(i, j, h[i][j], vis);

                if(pacific && atlantic) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    public void dfs(int i, int j, int prev, boolean[][] vis) {

        // reached Pacific
        if(i < 0 || j < 0) {
            pacific = true;
            return;
        }

        // reached Atlantic
        if(i >= n || j >= m) {
            atlantic = true;
            return;
        }

        if(vis[i][j] || h[i][j] > prev) return;

        vis[i][j] = true;

        dfs(i - 1, j, h[i][j], vis);
        dfs(i + 1, j, h[i][j], vis);
        dfs(i, j - 1, h[i][j], vis);
        dfs(i, j + 1, h[i][j], vis);
    }
}