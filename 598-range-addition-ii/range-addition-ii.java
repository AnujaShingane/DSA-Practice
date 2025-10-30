class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minx=m;
        int miny=n;
        
        for(int[] arr : ops){
            minx=Math.min(minx,arr[0]);
            miny=Math.min(miny,arr[1]);
        }
        
        return minx*miny;
    }
}