import java.util.*;

class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        ArrayList<Integer> res = new ArrayList<>();
        if (mat == null || mat.length == 0 || mat[0].length == 0) return res;

        int top = 0, bottom = mat.length - 1;
        int left = 0, right = mat[0].length - 1;

        while (left <= right && top <= bottom) {
            // Top row: left -> right
            for (int col = left; col <= right; col++) {
                res.add(mat[top][col]);
            }
            top++;

            // Right column: top -> bottom
            for (int row = top; row <= bottom; row++) {
                res.add(mat[row][right]);
            }
            right--;

            // Bottom row: right -> left  (only if a distinct row remains)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    res.add(mat[bottom][col]);
                }
                bottom--;
            }

            // Left column: bottom -> top (only if a distinct column remains)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    res.add(mat[row][left]);
                }
                left++;
            }
        }
        return res;
    }
}
