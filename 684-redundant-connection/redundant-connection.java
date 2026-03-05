class Solution {

    public int[] findRedundantConnection(int[][] edges) {

        int V = edges.length + 1;

        ArrayList<ArrayList<Integer>> adj = adjacencyList(V, edges);

        List<Integer> cycleNodes = findCycleNodes(V, adj);

        for (int i = edges.length - 1; i >= 0; i--) {
            if (cycleNodes.contains(edges[i][0]) &&
                cycleNodes.contains(edges[i][1])) {

                return new int[]{edges[i][0], edges[i][1]};
            }
        }

        return new int[]{};
    }

    public boolean dfs(int node, int parent,
                       boolean[] vis,
                       ArrayList<ArrayList<Integer>> adj,
                       int[] parentArr,
                       List<Integer> cycleNodes) {

        vis[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!vis[neighbor]) {

                parentArr[neighbor] = node;

                if (dfs(neighbor, node, vis, adj, parentArr, cycleNodes))
                    return true;
            }

            else if (neighbor != parent) {

                int current = node;

                cycleNodes.add(neighbor);

                while (current != neighbor) {
                    cycleNodes.add(current);
                    current = parentArr[current];
                }

                cycleNodes.add(neighbor);

                return true;
            }
        }

        return false;
    }

    public List<Integer> findCycleNodes(int n,
                                        ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[n];
        int[] parentArr = new int[n];
        List<Integer> cycleNodes = new ArrayList<>();

        Arrays.fill(parentArr, -1);

        for (int i = 1; i < n; i++) {

            if (!vis[i]) {

                if (dfs(i, -1, vis, adj, parentArr, cycleNodes))
                    break;
            }
        }

        return cycleNodes;
    }

    public ArrayList<ArrayList<Integer>> adjacencyList(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }
}