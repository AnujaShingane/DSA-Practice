/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> res = new ArrayList<>();
        if (node == null) return res;

        if (!isLeaf(node)) res.add(node.data);

        // 1. Left boundary (excluding leaves)
        addLeftBoundary(node.left, res);

        // 2. Leaf nodes
        addLeaves(node, res);

        // 3. Right boundary (excluding leaves, reversed)
        addRightBoundary(node.right, res);

        return res;
    }

    private boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

    private void addLeftBoundary(Node node, ArrayList<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) res.add(node.data);
            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    private void addLeaves(Node node, ArrayList<Integer> res) {
        if (node == null) return;
        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }
        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    private void addRightBoundary(Node node, ArrayList<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) stack.push(node.data);
            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }
}
