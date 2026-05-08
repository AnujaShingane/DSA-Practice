class Pair{
    int node;
    int wt;
    
    Pair(int node,int wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int spanningTree(int V, int[][] edges) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.wt - b.wt    
        );
        boolean[] vis = new boolean[V];
        int sum = 0;
        
        pq.add(new Pair(0,-1));
        
        ArrayList<ArrayList<Pair>> adj = adjList(V,edges);
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int wt = p.wt;
            
            if(vis[node])continue;
            vis[node]=true;
            if(wt!=-1)sum += wt;
            
            for(Pair p1 : adj.get(node)){
                pq.add(new Pair(p1.node,p1.wt));
            }
        }
        
        return sum;
    }
    
    public ArrayList<ArrayList<Pair>> adjList(int V , int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0],edge[2]));
        }
        
        return adj;
    }
}
