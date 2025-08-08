/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Solution {
    // Function to return the lowest common ancestor in a Binary Tree.
    Node lca(Node root, int n1, int n2) {
        ArrayList<Node> l1 = new ArrayList<>();
        ArrayList<Node> l2 = new ArrayList<>();
        
        getPath(root, n1 , l1);
        getPath(root, n2 , l2);
        
        int i = 0 , j = 0;
        Node res = null;
        while(i < l1.size() && j < l2.size()){
            if(l1.get(i) == l2.get(j)){
                res = l1.get(i);
            }
            i++;
            j++;
        }
        return res;
    }
    
    public boolean getPath(Node node, int B, List<Node> path) {
        if (node == null) return false;

        // Add current node to path
        path.add(node);

        // If current node is the target
        if (node.data == B) return true;

        // Recur for left and right
        if (getPath(node.left, B, path) || getPath(node.right, B, path)) {
            return true;
        }

        // Backtrack if B not found in this path
        path.remove(path.size() - 1);
        return false;
    }
}