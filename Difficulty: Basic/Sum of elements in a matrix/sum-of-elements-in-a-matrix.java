// User function Template for Java

class Solution {
    int sumOfMatrix(int N, int M, int[][] Grid) {
        // code here
        int sum = 0;
        int n=Grid.length;
        int m=Grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=Grid[i][j];
            }
        }
        return sum;
    }
}