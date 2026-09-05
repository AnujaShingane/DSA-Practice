class Pair{
    int node;
    int col;
    
    Pair(int node,int col){
        this.node = node;
        this.col = col;
    }
}

class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        List<List<Integer>> adj = adjList(V, edges);
        Queue<Pair> q = new LinkedList<>();
        int[] color = new int[V];
        Arrays.fill(color,-1);
        q.offer(new Pair(0,0));
        color[0] = 0;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int col = p.col;
            
            for(int nei : adj.get(node)){
                if(color[nei]==-1){
                    color[nei]=Math.abs(col-1);
                    q.offer(new Pair(nei,Math.abs(col-1)));
                }else{
                    if(color[nei]!=Math.abs(col-1)){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public List<List<Integer>> adjList(int V ,int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        return adj;
    }
}