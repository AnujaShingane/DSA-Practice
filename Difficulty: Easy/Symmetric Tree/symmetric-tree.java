/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {
    public boolean isSymmetric(Node root) {
        if(root == null)return true;
        return checkSym(root.left,root.right);
    }
    public boolean checkSym(Node leftNode,Node rightNode) {
        if(leftNode == null && rightNode == null)return true;
        if(leftNode == null || rightNode == null)return false;
        if(leftNode.data != rightNode.data){
            return false;
        }
        return checkSym(leftNode.left,rightNode.right) && checkSym(leftNode.right,rightNode.left);
    }
}