class Pair{
    int node;
    int parent;
    
    Pair(int node,int parent){
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        int n = V;
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adjlist.add(new ArrayList<>());
        
        for(int[] arr : edges){
            adjlist.get(arr[0]).add(arr[1]);
            adjlist.get(arr[1]).add(arr[0]);
        }
        
        boolean[] vis = new boolean[n];

        // 🔑 check all components
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i,-1));
                vis[i] = true;

                if(iscycle(adjlist, vis, q)) return true;
            }
        }
        return false;
    }
    
    public boolean iscycle(ArrayList<ArrayList<Integer>> adj,
                           boolean[] vis,
                           Queue<Pair> q){
        while(!q.isEmpty()){
            Pair rem = q.poll();
            int node = rem.node;
            int parent = rem.parent;
            
            for(int adjnode : adj.get(node)){
                if(vis[adjnode]){
                    if(parent != adjnode) return true;
                }
                else{
                    q.add(new Pair(adjnode, node));
                    vis[adjnode] = true;
                }
            }
        }
        return false;
    }
}
