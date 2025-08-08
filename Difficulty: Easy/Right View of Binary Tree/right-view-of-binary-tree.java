/*
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/

class Solution {
    ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        
        rightView(root,0,res);
        return res;
    }
    
    public void rightView(Node node,int level,ArrayList<Integer> res) {
        if(node == null)return;
        if(res.size() == level){
            res.add(node.data);
        }
        
        rightView(node.right,level+1,res);
        rightView(node.left,level+1,res);
    }
}