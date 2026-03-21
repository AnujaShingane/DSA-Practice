class Pair{
    int i;
    int j;
    int wt;
    
    Pair(int i, int j , int wt){
        this.i = i;
        this.j = j;
        this.wt = wt;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0 ; j < m ; j++){
                row.add(0);
            }
            res.add(row);
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==1){
                    res.get(i).set(j,0);
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.i;
            int c = p.j;
            int wt = p.wt;
            
            for(int i = 0 ; i < 4 ; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                int newWt = wt+1;
                
                if(nr<0 || nr>=n || nc<0 || nc>=m || vis[nr][nc])continue;
                
                vis[nr][nc]=true;
                q.offer(new Pair(nr,nc,newWt));
                res.get(nr).set(nc,newWt);
            }
        }
        
        return res;
    }
}