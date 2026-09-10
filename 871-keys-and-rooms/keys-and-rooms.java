class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        vis[0] = true;
        q.offer(0);

        while(!q.isEmpty()){
            int node = q.poll();

            for(int nei : rooms.get(node)){
                if(!vis[nei]){
                    vis[nei]=true;
                    q.offer(nei);
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(vis[i]==false)return false;
        }

        return true;
    }
}