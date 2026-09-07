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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return ans;
    }

    public int solve(TreeNode node){
        if(node == null){
            return 0;
        }

        int l = solve(node.left);
        int r = solve(node.right);

        ans = Math.max(ans,l+r);

        return 1 + Math.max(l,r);
    }
}