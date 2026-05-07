class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat = shortestDistance(n , edges);
        int cnt = 0;
        int minCnt = Integer.MAX_VALUE;
        int city = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j]<=distanceThreshold)cnt++;
            }
            if(cnt<=minCnt){
                minCnt = cnt;
                city = i;
            }
            cnt=0;
        }

        return city;
    }

    public int[][] shortestDistance(int n , int[][] edges){
        int[][] matrix = new int[n][n];

        for(int[] arr : matrix){
            Arrays.fill(arr,(int)(1e9));
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            matrix[u][v] = wt;
            matrix[v][u] = wt;
        }

        for(int i = 0 ; i < n ; i++){
            matrix[i][i] = 0;
        }

        for(int via = 0 ; via < n ; via++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via]+matrix[via][j]);
                }
            }
        }

        return matrix;
    } 
}