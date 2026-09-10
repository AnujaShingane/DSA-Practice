class Pair{
    int node;
    int wt;

    Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // manager -> employee
        for (int i = 0; i < n; i++) {

            if (manager[i] != -1) {

                adj.get(manager[i]).add(
                    new Pair(i, informTime[manager[i]])
                );
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt-b.wt);
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[headID] = 0;
        pq.offer(new Pair(headID, 0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int wt = p.wt;

            if(wt>dist[node])continue;

            for(Pair nei : adj.get(node)){
                int no = nei.node;
                int w = nei.wt;
                int newWt = w+wt;

                if(newWt<dist[no]){
                    dist[no] = newWt;
                    pq.offer(new Pair(no,newWt));
                }
            }
        }

        int max = 0;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max,dist[i]);
        }

        return max==Integer.MAX_VALUE ? -1 : max;
    }
}