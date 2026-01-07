class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0]-b[0]
        );
        int[] dist = new int[V];
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        adj = adj(V ,edges);
        
        for(int i = 0 ;i < V ; i++)dist[i]=Integer.MAX_VALUE;
        dist[src] = 0;
        pq.add(new int[]{0,src});
        
        while(!pq.isEmpty()){
            int[] remarr = pq.poll();
            int remdist = remarr[0];
            int remnode = remarr[1];
            
            for(int[] arradj : adj.get(remnode)){
                int adjnode = arradj[0];
                int adjdist = arradj[1];
                
                if(adjdist+remdist < dist[adjnode]){
                    dist[adjnode]=adjdist+remdist;
                    pq.add(new int[]{adjdist+remdist,adjnode});
                }
            }
        }
        
        return dist;
    }
    
    public ArrayList<ArrayList<int[]>> adj(int V , int[][] edges){
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++)adj.add(new ArrayList<>());
        
        for(int[] arr : edges){
            adj.get(arr[0]).add(new int[]{arr[1],arr[2]});
            adj.get(arr[1]).add(new int[]{arr[0],arr[2]});
        }
        
        return adj;
    }
}