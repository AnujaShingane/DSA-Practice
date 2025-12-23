class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        // directed graph
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
        }
        
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(i, vis, pathVis, adj)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int node,
                        boolean[] vis,
                        boolean[] pathVis,
                        ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        pathVis[node] = true;
        
        for(int ele : adj.get(node)){
            if(!vis[ele]){
                if(dfs(ele, vis, pathVis, adj)) return true;
            }
            else if(pathVis[ele]){
                return true;   // 🔁 back-edge → cycle
            }
        }
        
        pathVis[node] = false; // backtrack
        return false;
    }
}
