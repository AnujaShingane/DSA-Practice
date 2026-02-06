class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0]==1 || grid[n-1][m-1]==1)return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        grid[0][0]=1;
        
        int[][] dir = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},       {0,1},
            {1,-1},{1,0},{1,1}
        };

        int pathlen = 1;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 1 ; i <= size ; i++){
                int[] arr = q.poll();
                int r = arr[0];
                int c = arr[1];

                if(r==n-1 && c==m-1)return pathlen;

                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr<0 || nc<0 || nr>=n || nc>=m || grid[nr][nc]==1)continue;

                    grid[nr][nc]=1;
                    q.add(new int[]{nr,nc});
                }
            }
            pathlen++;
        }

        return -1;
    }
}