class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        
        //adjecency list
        for(int[] arr : prerequisites){
            adj.get(arr[1]).add(arr[0]);
        }

        if(cycle(numCourses,adj))return false;
        
        return true;
    }

    public boolean cycle(int numCourses,ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            if(!vis[i]){
                if(dfs(i, vis, pathVis, adj)) return true;
            }
        }
        return false;
    }

    public boolean dfs(int node,
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
                return true;
            }
        }
        
        pathVis[node] = false; // backtrack
        return false;
    }

}


/*
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
                return true;
            }
        }
        
        pathVis[node] = false; // backtrack
        return false;
    }
}
*/