class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        List<List<Integer>> adj = adjList(isConnected);
        boolean[] vis = new boolean[n+1];
        int cnt = 0;

        for(int i = 1 ; i <= n ; i++){
            if(!vis[i]){
                cnt++;
                dfs(i,adj,vis);
            }
        }

        return cnt;
    }

    public void dfs(int node,List<List<Integer>> adj,boolean[] vis) {
        vis[node]=true;

        for(int nei : adj.get(node)){
            if(!vis[nei]){
                dfs(nei,adj,vis);
            }
        }
    }

    public List<List<Integer>> adjList(int[][] isConnected){
        int n = isConnected.length;
        int m = isConnected[0].length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(isConnected[i][j]==1){
                    adj.get(i+1).add(j+1);
                    adj.get(j+1).add(i+1);
                }
            }
        }

        return adj;
    }
}