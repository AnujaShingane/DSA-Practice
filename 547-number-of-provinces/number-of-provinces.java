class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        ArrayList<ArrayList<Integer>> adj = buildAdj(n, isConnected);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cnt++;
                bfs(i, adj, vis);
            }
        }
        return cnt;
    }

    private ArrayList<ArrayList<Integer>> buildAdj(int n, int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }
        return adj;
    }

    private void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nbr : adj.get(node)) {
                if (!vis[nbr]) {
                    vis[nbr] = true;
                    q.add(nbr);
                }
            }
        }
    }
}
