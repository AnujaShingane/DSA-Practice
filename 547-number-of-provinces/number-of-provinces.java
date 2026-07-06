class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        boolean[] vis = new boolean[n];

        List<List<Integer>> adj = adjList(n,m,isConnected);

        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                cnt++;
                dfs(i,vis,adj);
            }
        }

        return cnt;
    }

    public void dfs(int node,boolean[] vis,List<List<Integer>> adj) {
        vis[node] = true;

        for(int nei : adj.get(node)){
            if(!vis[nei]){
                dfs(nei,vis,adj);
            }
        }
    }

    public List<List<Integer>> adjList(int n,int m,int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i!=j && isConnected[i][j] == 1)adj.get(i).add(j);
            }
        }

        return adj;
    }
}