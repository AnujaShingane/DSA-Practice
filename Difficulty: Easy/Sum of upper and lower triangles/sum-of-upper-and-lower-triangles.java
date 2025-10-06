
class Solution {
    public ArrayList<Integer> sumTriangles(int mat[][]) {
        // code here
        int uS=0;
        int lS=0;
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j<=i)lS+=mat[i][j];
                if(i<=j)uS+=mat[i][j];
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(uS);
        res.add(lS);
        return res;
    }
}