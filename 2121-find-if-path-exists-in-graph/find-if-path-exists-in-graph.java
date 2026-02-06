class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        adj = adjList(n,edges,adj);

        int[] vis = new int[n];

        dfs(source,vis,adj);

        if(vis[destination]==0)return false;
        return true;
    }

    public void dfs(int node,int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node]=1;

        for(int ele : adj.get(node)){
            if(vis[ele]==0){
                dfs(ele,vis,adj);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> adjList(int n, int[][] edges,ArrayList<ArrayList<Integer>> adj) {
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        return adj;
    }
}