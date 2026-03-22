class Pair{
    int node;
    double prob;

    Pair(int node, double prob){
        this.node= node;
        this.prob = prob;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = adjList(n,edges,succProb);
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->Double.compare(b.prob,a.prob)
        );
        boolean[] vis = new boolean[n];
        double[] prob = new double[n];
        pq.add(new Pair(start_node,1.0));
        Arrays.fill(prob,0.0);
        prob[start_node]=1.0;
        vis[start_node]=true;

        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            int node = p1.node;
            double p = p1.prob;
            vis[node]=true;

            if(node == end_node)return p;

            for(Pair p2 : adj.get(node)){
                int nn = p2.node;
                double pp = p2.prob;
                double np = p*pp;

                if(prob[nn]<np){
                    prob[nn]=np;
                    pq.add(new Pair(nn,np));
                }
            }
        }

        return 0.0;
    }

    public ArrayList<ArrayList<Pair>> adjList(int n,int[][] edges,double[] succProb) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int j = 0 ; j < edges.length ; j++){
            adj.get(edges[j][0]).add(new Pair(edges[j][1],succProb[j]));
            adj.get(edges[j][1]).add(new Pair(edges[j][0],succProb[j]));
        }

        return adj;
    }
}