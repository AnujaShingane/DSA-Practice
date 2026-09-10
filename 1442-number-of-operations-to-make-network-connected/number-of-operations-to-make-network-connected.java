class DisjointSet{
    int[] rank;
    int[] parent;

    DisjointSet(int n){
        rank = new int[n];
        parent = new int[n];

        for(int i = 0 ; i < n ; i++){
            rank[i]=0;
            parent[i]=i;
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
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int cntExtra = 0;

        for(int[] arr : connections){
            if(ds.findUPar(arr[0])==ds.findUPar(arr[1])){
                cntExtra++;
            }else{
                ds.unionByRank(arr[0],arr[1]);
            }
        }

        int components = 0;
        for(int i = 0 ; i < n ; i++){
            if(ds.findUPar(i)==i){
                components++;
            }
        }

        int need = components-1;
        if(need>cntExtra)return -1;
        return need;
    }
}