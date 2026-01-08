class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] ans = new int[2];
        int max = Integer.MIN_VALUE;
        int ansrow=0;

        for(int i = 0 ; i < n ; i++){
            int row = i;
            int cnt = 0;
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j]==1)cnt++;
            }
            if(cnt>max){
                max=cnt;
                ansrow = row;
            }else if(cnt==max){
                ansrow=Math.min(ansrow,row);
                max = cnt;
            }
        }

        return new int[]{ansrow,max};
    }
}