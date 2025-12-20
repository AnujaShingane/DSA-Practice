class Pair{
    int i;
    int j;
    
    Pair(int i , int j ){
        this.i = i;
        this.j = j;
    }
}

class PairDist {
    Pair p;
    int dist;
    
    PairDist(Pair p , int dist){
        this.p = p;
        this.dist = dist;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        Queue<PairDist> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0 ; j < m ; j++){
                row.add(0);
            }
            ans.add(row);
        }
        
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    vis[i][j] = true;
                    q.add(new PairDist(new Pair(i,j),0));
                    ans.get(i).set(j,0);
                }
            }
        }
        
        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};
        
        while(!q.isEmpty()){
            PairDist pd = q.poll();
            Pair p = pd.p;
            int row = p.i;
            int col = p.j;
            int dist = pd.dist;
            
            for(int i = 0 ; i < 4 ; i++){
                int dr = row + delr[i];
                int dc = col + delc[i];
                
                if(dr>= 0 && dr<n && dc >= 0 && dc <m && vis[dr][dc]==false){
                    vis[dr][dc] = true;
                    q.add(new PairDist(new Pair(dr,dc),dist+1));
                    ans.get(dr).set(dc,dist+1);
                }   
            }
        }
        return ans;
    }
}