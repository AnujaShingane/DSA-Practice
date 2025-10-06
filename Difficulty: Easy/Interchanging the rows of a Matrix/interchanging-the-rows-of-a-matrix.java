class Solution {
    // Function to interchange the rows of a matrix.
    static void interchangeRows(int matrix[][]) {
        // code here
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0 ; i < n/2 ; i++){
            for(int j = 0 ;j < m ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j]=temp;
            }
        }
    }
}