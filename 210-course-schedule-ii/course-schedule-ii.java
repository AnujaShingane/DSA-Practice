class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> topoSort = topoSort(numCourses,prerequisites);
        int[] ans = new int[topoSort.size()];
        for(int i = 0 ; i < topoSort.size() ; i++){
            ans[i]=topoSort.get(i);
        }
        
        if(topoSort.size()!=numCourses)return new int[]{};
        return ans;
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
    
    public ArrayList<ArrayList<Integer>> adj(int V,int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i < V ; i++)adj.add(new ArrayList<>());
        
        for(int[] arr : edges){
            adj.get(arr[1]).add(arr[0]);
        }
        return adj;
    }
}