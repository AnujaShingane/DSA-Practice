class Pair{
    int node;
    int dist;
    
    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++)adj.add(new ArrayList<>());
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0));
        int[] dist = new int[V];
        for(int i = 0 ; i < V ; i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int nod = p.node;
            int dis = p.dist;
            
            for(int ele : adj.get(nod)){
                if(dist[ele]==Integer.MAX_VALUE){
                    dist[ele]=dis+1;
                    q.add(new Pair(ele,dis+1));
                }
            }
        }
        
        for(int i = 0 ; i < V ;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        
        return dist;
    }
}
