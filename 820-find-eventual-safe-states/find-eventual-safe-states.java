class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        ArrayList<Integer> topoSort = topoSort(V,graph);
        Collections.sort(topoSort);
        return topoSort;
    }

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = adj(V,edges);
        
        for(List<Integer> list : adj){
            for(int ele : list){
                indegree[ele]++;
            }
        }
        
        for(int i = 0 ; i < V ; i++){
            if(indegree[i]==0)q.add(i);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int ele = q.poll();
            ans.add(ele);
            
            for(int ele2 : adj.get(ele)){
                indegree[ele2]--;
                if(indegree[ele2]==0)q.add(ele2);
            }
        }
        return ans;
    }
    
    public ArrayList<ArrayList<Integer>> adj(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int i = 0; i < V; i++) {
            for (int v : edges[i]) {
                adj.get(v).add(i); // reverse edge
            }
        }
        return adj;
    }
}
