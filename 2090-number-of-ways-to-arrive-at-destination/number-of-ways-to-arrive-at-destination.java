class Pair {
    int node;
    long dist;

    Pair(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    int MOD = (int)(1e9+7);
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = adjList(n,roads);
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> Long.compare(a.dist,b.dist)
        );
        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        long[] ways = new long[n];
        dist[0]=0;
        ways[0]=1;
        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int nod = p.node;
            long dis = p.dist;

            for(Pair p1 : adj.get(nod)){
                int n1 = p1.node;
                long d = p1.dist;
                long nd = dis+d;

                if(nd<dist[n1]){
                    dist[n1]=nd;
                    pq.offer(new Pair(n1,nd));
                    ways[n1]=ways[nod];
                }else if(nd==dist[n1]){
                    ways[n1]=(ways[n1]+ways[nod])%MOD;
                }
            }
        }

        return ((int)(ways[n-1]))%MOD;
    }

    public ArrayList<ArrayList<Pair>> adjList(int n,int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] r : roads) {
            int u = r[0], v = r[1], w = r[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        return adj;
    }
}