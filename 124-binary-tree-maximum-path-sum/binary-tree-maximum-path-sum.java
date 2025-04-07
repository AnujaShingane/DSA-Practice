/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maximumPath(root, maxSum);
        return maxSum[0];
    }

    public static int maximumPath(TreeNode root, int[] maxSum){
        if(root == null) return 0;
        // Not Consider Negative Value Take "0" Instead
        int lSum = Math.max(0, maximumPath(root.left, maxSum));
        // Not Consider Negative Value Take "0" Instead
        int rSum = Math.max(0, maximumPath(root.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], root.val + (lSum + rSum));
        return root.val + Math.max(lSum, rSum);
    }
}