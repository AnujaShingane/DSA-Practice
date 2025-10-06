class Solution {
    static boolean multiplyMatrix(int[][] mat1, int[][] mat2, int[][] result) {
        int n1 = mat1.length;
        if (n1 == 0) return false;
        int m1 = mat1[0].length;

        int n2 = mat2.length;
        if (n2 == 0) return false;
        int m2 = mat2[0].length;

        // Check compatibility and result shape: (n1 x m1) * (n2 x m2) where m1 == n2 -> (n1 x m2)
        if (m1 != n2) return false;
        if (result.length != n1 || result[0].length != m2) return false;

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                long sum = 0; // use long to avoid intermediate overflow
                for (int k = 0; k < m1; k++) {
                    sum += (long) mat1[i][k] * mat2[k][j]; // note: [k][j], not [j][i]
                }
                if(result[i][j] == (int)sum)continue;
                else return false;
            }
        }
        return true;
    }
}
