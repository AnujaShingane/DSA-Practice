class Solution {
    int count;
    public int countCompleteComponents(int n, int[][] edges) {
        int cnt = 0;
        ArrayList<ArrayList<Integer>> adj = adjList(n,edges);
        boolean[] vis = new boolean[n];
        boolean complete = true;
        
        for(int i = 0 ; i < n ; i++){
            complete = true;
            if(!vis[i]){
                ArrayList<Integer> list = new ArrayList<>();
                dfs(i,vis,list,adj);

                int size = list.size();
                for(int node : list){
                    if(adj.get(node).size()!=size-1){
                        complete = false;
                        break;
                    }
                }

                if(complete)cnt++;
            }
        }

        return cnt;
    }

    public void dfs(int node,boolean[] vis,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        list.add(node);

        for(int nei : adj.get(node)){
            if(!vis[nei]){
                dfs(nei,vis,list,adj);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> adjList(int n , int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        return adj;
    }
}