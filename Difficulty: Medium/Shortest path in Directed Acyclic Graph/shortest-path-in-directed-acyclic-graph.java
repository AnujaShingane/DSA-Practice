class Pair{
    int nod;
    int wt;
    
    Pair(int nod, int wt){
        this.nod = nod;
        this.wt = wt;
    }
}

class Solution {
    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr : edges){
            adj.get(arr[0]).add(new Pair(arr[1],arr[2]));
        }
        
        
        //step1
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                dfs(i,vis,st,adj);
            }
        }
        
        
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        
        
        //step2
        while(!st.isEmpty()){
            int stnode = st.pop();
            int dis = dist[stnode];
            
            if(dist[stnode] != Integer.MAX_VALUE){
                for(Pair p : adj.get(stnode)){
                    int n = p.nod;
                    int wt = p.wt;
                    
                    dist[n]=Math.min(dist[n],dis+wt);
                }
            }
        }
        
        for(int i = 0 ; i < V ; i++){
            if(dist[i]==Integer.MAX_VALUE)dist[i]=-1;
        }
        
        return dist;
    }
    
    public void dfs(int node, boolean[] vis , Stack<Integer> st, ArrayList<ArrayList<Pair>> adj ){
        vis[node]=true;
        
        for(Pair p : adj.get(node)){
            int n = p.nod;
            int wt = p.wt;
            
            if(!vis[n])dfs(n,vis,st,adj);
        }
        
        st.push(node);
    }
}