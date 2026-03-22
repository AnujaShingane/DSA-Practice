class Pair{
    int node;
    Double prob;

    Pair(int node,double prob){
        this.node=node;
        this.prob=prob;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = adjList(n,edges,succProb);
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> Double.compare(b.prob,a.prob)
        );
        boolean[] vis = new boolean[n];
        double[] prob = new double[n];
        Arrays.fill(prob,0.0);
        pq.add(new Pair(start_node,1.0));
        vis[start_node]=true;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int curr = p.node;
            double pro = p.prob;

            vis[curr]=true;
            if(curr==end_node)return pro;

            for(Pair pp : adj.get(curr)){
                int ele = pp.node;
                double probab = pp.prob;

                double np = pro*probab;

                if(vis[ele])continue;

                if(prob[ele]<np){
                    prob[ele]=np;
                    pq.add(new Pair(ele,np));
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