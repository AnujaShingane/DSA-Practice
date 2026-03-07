class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
        int[] dist = new int[n];
        for(int i = 0 ; i < n ; i++){
            dist[i]=(int)(1e9);
        }
        dist[src] = 0;

        for(int i = 0 ; i < k+1 ; i++){
            int[] temp = dist.clone();

            for(int[] edge : flights){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                
                if(dist[u]!=(int)(1e9) && dist[u] + wt < temp[v]){
                    temp[v] = dist[u] + wt;
                }
            }
            dist = temp;
        }

        return dist[dst] == (int)(1e9) ? -1 : dist[dst];
    }
}