class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
                ans[i][j]=grid[i][j];
            }
        }

        int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};

        int min = 0;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int r = arr[0];
            int c = arr[1];
            int time = arr[2];

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr<0 || nc<0 || nr>=n || nc>=m || ans[nr][nc]==0 || ans[nr][nc]==2){
                    continue;
                }

                ans[nr][nc] = 2;
                q.add(new int[]{nr,nc,time+1});
                min = Math.max(min,time+1);
            }
        }
        
        for(int[] array : ans){
            for(int ele : array){
                if(ele==1)return -1;
            }
        }

        return min;
    }
}