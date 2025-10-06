class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int j=0;j<m;j++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(mat[i][j]);
            }
            res.add(list);
        }
        
        return res;
    }
}