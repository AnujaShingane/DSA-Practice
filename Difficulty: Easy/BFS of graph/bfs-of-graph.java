class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[n];
        q.add(0);
        vis[0]=1;
        
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            
            for(int ele : adj.get(node)){
                if(vis[ele]==0){
                    vis[ele]=1;
                    q.add(ele);
                }
            }
        }
        
        return ans;
    }
}