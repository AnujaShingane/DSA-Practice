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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null){
            return result;
        }
        
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> sublist = new ArrayList<>();

            for(int i = 0 ; i < size ; i++){
                TreeNode rem = q.poll();
                sublist.add(rem.val);

                if(rem.left != null){
                    q.offer(rem.left);
                }

                if(rem.right != null){
                    q.offer(rem.right);
                }
            }
            result.add(sublist);
        }
        return result;
    }
}