class Pair{
    int node;
    double wt;
    
    Pair(int node, double wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] dist = new double[n];
        List<List<Pair>> adj = adjList( n,  edges,  succProb,  start_node, end_node);
        Arrays.fill(dist,Integer.MIN_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.wt,a.wt));
        pq.add(new Pair(start_node,1));
        dist[start_node] = 1;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            double wt = p.wt;

            if(wt<dist[node])continue;

            for(Pair nei : adj.get(node)){
                int no = nei.node;
                double w = nei.wt;
                double nwt = w * wt;

                if(nwt>dist[no]){
                    dist[no] = nwt;
                    pq.offer(new Pair(no,nwt));
                }
            }
        }

        return dist[end_node]==Integer.MIN_VALUE ? 0 : dist[end_node];
    }

    public List<List<Pair>> adjList(int n, int[][] edges, double[] succProb, int start_node, int end_node){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        int ptr = 0;
        for(int[] arr : edges){
            adj.get(arr[0]).add(new Pair(arr[1],succProb[ptr]));
            adj.get(arr[1]).add(new Pair(arr[0],succProb[ptr]));

            ptr++;
        }

        return adj;
    }
}