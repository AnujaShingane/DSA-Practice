class DisjointSet {

    int[] size;
    int[] parent;

    public DisjointSet(int n) {

        size = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findUPar(int node) {

        if (node == parent[node]) {
            return node;
        }

        // Path compression
        return parent[node] = findUPar(parent[node]);
    }

    public void unionBySize(int u, int v) {

        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) {
            return;
        }

        if (size[ulp_u] < size[ulp_v]) {

            parent[ulp_u] = ulp_v;
            size[ulp_v] = size[ulp_v] + size[ulp_u];

        } else {

            parent[ulp_v] = ulp_u;
            size[ulp_u] = size[ulp_u] + size[ulp_v];
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(isConnected[i][j]==1){
                    ds.unionBySize(i,j);
                }
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(ds.findUPar(i)==i){
                cnt++;
            }
        }

        return cnt;
    }
}