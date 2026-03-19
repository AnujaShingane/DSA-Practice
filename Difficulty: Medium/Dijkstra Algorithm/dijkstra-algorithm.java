class Pair{
    int node;
    int wt;
    
    Pair(int node,int wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = adjecencyList(V,edges);
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.wt-b.wt
        );
        int[] dist = new int[V];
        for(int i = 0 ; i < V ; i++){
            dist[i] = (int)(1e9);
        }
        
        pq.add(new Pair(src,0));
        dist[src]=0;
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int n = p.node;
            int dis = p.wt;
            
            for(Pair ele : adj.get(n)){
                int node = ele.node;
                int distance = ele.wt;
                int finalDist = dis+distance;
                
                if(dist[node]>finalDist){
                    dist[node] = finalDist;
                    pq.add(new Pair(node,finalDist));
                }
            }
        }
        
        for(int i = 0 ; i < V ; i++){
            if(dist[i]==(int)(1e9)){
                dist[i]=-1;
            }
        }
        
        return dist;
    }
    
    public ArrayList<ArrayList<Pair>> adjecencyList(int V , int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr : edges){
            adj.get(arr[0]).add(new Pair(arr[1],arr[2]));
            adj.get(arr[1]).add(new Pair(arr[0],arr[2]));
        }
        
        return adj;
    }
}
