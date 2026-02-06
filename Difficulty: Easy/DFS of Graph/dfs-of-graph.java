class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[n];
        
        dfs(0,adj,vis,ans);
        
        return ans;
    }
    
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,ArrayList<Integer> ans) {
        vis[node]=1;
        ans.add(node);
        
        for(int ele : adj.get(node)){
            if(vis[ele]==0){
                dfs(ele,adj,vis,ans);
            }
        }
    }
}