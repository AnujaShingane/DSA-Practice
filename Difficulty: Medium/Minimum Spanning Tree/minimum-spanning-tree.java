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
    public int spanningTree(int V, int[][] edges) {
        Arrays.sort(edges,(a,b)->a[2]-b[2]);
        DisjointSet ds = new DisjointSet(V);
        int cnt = 0;
        
        for(int[] edge : edges){
            if(ds.findUPar(edge[0])!=ds.findUPar(edge[1])){
                ds.unionBySize(edge[0],edge[1]);
                cnt+=edge[2];
            }
        }
        
        return cnt;
    }
}
