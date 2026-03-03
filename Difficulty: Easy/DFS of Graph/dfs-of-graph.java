class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[n];
        
        dfs(0,adj,vis,res);
        
        return res;
    }
    
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,
                    boolean[] vis,ArrayList<Integer> res){
        vis[node]=true;
        res.add(node);
        
        for(int ele : adj.get(node)){
            if(!vis[ele]){
                dfs(ele,adj,vis,res);
            }
        }
    }
}