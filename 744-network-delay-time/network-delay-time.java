class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = adjList(n,times);
        int[] arr = dijkstra(n,adj,k);
        int max = 0;

        for(int i=1;i<=n;i++){
            if(arr[i]==Integer.MAX_VALUE) return -1;
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    class Pair {
        int node, dist;
        Pair(int n, int d) {
            node = n;
            dist = d;
        }
    }

    public int[] dijkstra(int n1, ArrayList<ArrayList<Pair>> adj, int src) {
        int[] dist = new int[n1+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int d = curr.dist;

            if(d>dist[node])continue;

            //relaxation of edges
            for (Pair nei : adj.get(node)) {
                int n = nei.node;
                int dis = nei.dist;
                int newDist = dis+d;

                if(newDist<dist[n]){
                    dist[n] = newDist;
                    pq.offer(new Pair(n,newDist));
                }
            }
        }
        return dist;
    }


    public ArrayList<ArrayList<Pair>> adjList(int n, int[][] times) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] arr : times) {
            adj.get(arr[0]).add(new Pair(arr[1],arr[2]));
        }

        return adj;
    }
}