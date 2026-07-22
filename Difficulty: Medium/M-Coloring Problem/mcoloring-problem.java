class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        List<List<Integer>> adj = adjList(v,edges);
        int[] color = new int[v];
        
        if(func(0,v,color,adj,m))return true;
        
        return false;
    }
    
    public boolean func(int ind,int n,int[] color,List<List<Integer>> adj,int m){
        if(ind==n){
            return true;
        }
        
        for(int i = 1 ; i <= m ; i++){
            if(canColor(ind,i,color,adj)){
                color[ind]=i;
                if(func(ind+1,n,color,adj,m)==true)return true;
                color[ind] = 0;
            }
        }
        
        return false;
    }
    
    public boolean canColor(int ind,int col,int[] color,List<List<Integer>> adj){
        for(int nei : adj.get(ind)){
            if(color[nei]==col)return false;
        }
        
        return true;
    }
    
    public List<List<Integer>> adjList(int v , int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < v ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        return adj;
    }
}