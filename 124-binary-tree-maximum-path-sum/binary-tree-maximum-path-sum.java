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
        int[] path = new int[1];
        path[0] = Integer.MIN_VALUE;
        maxPath(root,path);
        return path[0];
    }
   
    public int maxPath(TreeNode root,int[] path) {
        if(root == null)return 0;
        int lS = Math.max(0,maxPath(root.left,path));
        int rS = Math.max(0,maxPath(root.right,path));
        path[0] = Math.max(path[0],lS+rS+root.val);
        return root.val+Math.max(lS,rS);
    }
}