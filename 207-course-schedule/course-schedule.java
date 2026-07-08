class Solution { 
    public boolean canFinish(int numCourses, int[][] prerequisites) { 
        int n = numCourses; 
        List<List<Integer>> adj = adjList(prerequisites,numCourses); 
        boolean[] vis = new boolean[n]; 
        boolean[] pathvis = new boolean[n]; 
 
        for(int i = 0 ; i < n ; i++){ 
            if(!vis[i]){ 
                if(cycleDetection(i,vis,pathvis,adj))return false; 
            } 
        } 
 
        return true; 
    } 
 
    public boolean cycleDetection(int node,boolean[] vis,boolean[] 
pathvis,List<List<Integer>> adj) { 
        vis[node] = true; 
        pathvis[node] = true; 
 
        for(int nei : adj.get(node)){ 
            if(!vis[nei]){ 
                if(cycleDetection(nei, vis, pathvis, adj)) return true; 
            }else if(vis[nei] && pathvis[nei]){ 
                return true; 
            } 
        } 
 
        pathvis[node] = false; 
        return false; 
    } 
 
    public List<List<Integer>> adjList(int[][] prerequisites,int n){ 
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0 ; i < n ; i++){ 
            adj.add(new ArrayList<>()); 
        } 
 
        for(int[] arr : prerequisites){ 
            adj.get(arr[1]).add(arr[0]); 
        } 
 
        return adj; 
    } 
}