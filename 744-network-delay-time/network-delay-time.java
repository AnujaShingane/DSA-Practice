class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,(int)(1e8));
        dist[k]=0;

        for(int i = 0 ; i < n-1 ; i++){
            for(int[] edge : times){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(dist[u]!=(int)(1e8) && dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1 ; i < n+1 ; i++){
            if(dist[i]==(int)(1e8))return -1;
            ans = Math.max(ans,dist[i]);
        }
        return ans;
    }
}