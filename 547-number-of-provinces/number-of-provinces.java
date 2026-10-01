class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        boolean[] vis = new boolean[n+1];
        vis[0]=true;
        int cnt = 0;
        List<List<Integer>> adj = adjList( isConnected);

        for(int i = 1 ; i <= n ; i++){
            if(!vis[i]){
                cnt++;
                dfs(i,adj,vis);
            }
        }

        return cnt;
    }

    public void dfs(int node,List<List<Integer>> adj,boolean[] vis){
        vis[node] = true;

        for(int nei : adj.get(node)){
            if(!vis[nei]){
                dfs(nei,adj,vis);
            }
        }
    }

    public List<List<Integer>> adjList(int[][] isConnected){
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++){
            int fn = i+1;
            for(int j = 0 ; j < n ; j++){
                int sn = j+1;
                if(isConnected[i][j]==1){
                    adj.get(fn).add(sn);
                    adj.get(sn).add(fn);
                }
            }
        }

        return adj;
    }
}