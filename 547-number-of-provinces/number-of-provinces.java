class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected[0].length;
        boolean[] vis = new boolean[n];
        int cnt = 0;

        ArrayList<ArrayList<Integer>> adj = adj(n, isConnected);

        for(int i = 0 ; i < n ; i++){
            if(vis[i]==false){
                cnt++;
                bfs(i,vis,isConnected,adj);
            }
        }
        return cnt;
    }

    public void bfs(int start, boolean[] vis,int[][] isConnected,ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start]=true;

        while(!q.isEmpty()){
            int rem = q.poll();
            for(int num : adj.get(rem)){
                if(vis[num]==false){
                    vis[num]=true;
                    q.add(num);
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> adj(int n, int[][] isConnected){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++)adj.add(new ArrayList<>());

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }
        return adj;
    }
}