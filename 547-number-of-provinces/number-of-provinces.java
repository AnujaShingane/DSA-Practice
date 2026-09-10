class DisjointSet{
    int[] rank;
    int[] parent;

    DisjointSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];

        for(int i = 0 ; i <= n ; i++){
            rank[i]=0;
            parent[i] = i;
        }
    }

    public int findUPar(int node){
        if(node==parent[node]){
            return node;
        }

        return parent[node] = findUPar(parent[node]);
    }

    public void unionByRank(int u,int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(rank[ulp_u]<rank[ulp_v]){
            parent[ulp_u]=ulp_v;
        }else if(rank[ulp_u]>rank[ulp_v]){
            parent[ulp_v]=ulp_u;
        }else{
            parent[ulp_u]=ulp_v;
            rank[ulp_v]+=1;
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        DisjointSet ds = new DisjointSet(n);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i!=j && isConnected[i][j]==1){
                    ds.unionByRank(i+1,j+1);
                }
            }
        }

        int cnt = 0;
        for(int i = 1 ; i <= n ; i++){
            if(ds.findUPar(i)==i){
                cnt++;
            }
        }

        return cnt;
    }
}