class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        
        q.offer(0);
        vis[0]=true;
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int ele : adj.get(node)){
                if(!vis[ele]){
                    vis[ele] = true;
                    q.add(ele);
                }
            }
            
            res.add(node);
        }
        return res;
    }
}