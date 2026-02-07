class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        adj = adjList(V,edges,adj);
        
        int[] vis = new int[V];
        
        for(int i = 0 ; i < V ; i++){
            if(vis[i]==0){
                if(dfs(i,-1,vis,adj)==true)return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(int node,int parent ,int[] vis ,ArrayList<ArrayList<Integer>> adj) {
        vis[node]=1;
        
        for(int ele : adj.get(node)){
            if(vis[ele]==0){
                if(dfs(ele,node,vis,adj))return true;
            }else{
                if(ele!=parent)return true;
            }
        }
        return false;
    }
    
    public ArrayList<ArrayList<Integer>> adjList(int n, int[][] edges,ArrayList<ArrayList<Integer>> adj) {
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        return adj;
    }
}