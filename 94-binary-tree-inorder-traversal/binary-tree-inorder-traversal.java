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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // if(root == null){
        //     return result;
        // }
        inorderHelper(result,root);
        return result;
    }

    public void inorderHelper(List<Integer> result,TreeNode root){
        if(root == null){
            return;
        }
        inorderHelper(result, root.left);
        result.add(root.val);
        inorderHelper(result, root.right);
    }
}