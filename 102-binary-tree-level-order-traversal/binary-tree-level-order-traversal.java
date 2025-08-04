class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size(); // number of nodes at the current level
            List<Integer> sublist = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sublist.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            res.add(sublist);
        }

        return res;
    }
}
