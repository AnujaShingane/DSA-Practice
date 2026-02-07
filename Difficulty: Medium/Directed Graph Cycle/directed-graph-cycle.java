class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        adj = adjList(V,edges,adj);
        
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        
        for(int i = 0 ; i < V ; i++){
            if(dfs(i,adj,vis,pathVis))return true;
        }
        return false;
    }
    
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,int[] vis , int[] pathVis) {
        vis[node]=1;
        pathVis[node]=1;
        
        //traverse for all node
        for(int ele : adj.get(node)){
            if(vis[ele]==0){
                if(dfs(ele,adj,vis,pathVis))return true;
            }else{
                if(pathVis[ele]==1)return true;
            }
        }
        
        pathVis[node]=0; //backtrack // making 0 while returning
        return false;
    }
    
    public ArrayList<ArrayList<Integer>> adjList(int n, int[][] edges,ArrayList<ArrayList<Integer>> adj) {
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
        }

        return adj;
    }
}