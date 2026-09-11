class Pair{
    int node;
    int wt;
    
    Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        List<List<Pair>> adj = adjList(times,n ,k);
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
        pq.add(new Pair(k,0));
        dist[k] = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int wt = p.wt;

            if(wt>dist[node])continue;

            for(Pair nei : adj.get(node)){
                int no = nei.node;
                int w = nei.wt;
                int nwt = w + wt;

                if(nwt<dist[no]){
                    dist[no] = nwt;
                    pq.offer(new Pair(no,nwt));
                }
            }
        }

        int max = 0;
        for(int i = 1 ; i <= n ; i++){
            max = Math.max(max,dist[i]);
        }

        return max==Integer.MAX_VALUE ? -1 : max;
    }

    public List<List<Pair>> adjList(int[][] times , int n , int k){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] arr : times){
            adj.get(arr[0]).add(new Pair(arr[1],arr[2]));
        }

        return adj;
    }
}