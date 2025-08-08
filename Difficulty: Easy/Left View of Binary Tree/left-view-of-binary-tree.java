/*
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
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        
        leftView(root,0,res);
        return res;
    }
    
    public void leftView(Node node,int level,ArrayList<Integer> res) {
        if(node == null)return;
        if(res.size() == level){
            res.add(node.data);
        }
        
        leftView(node.left,level+1,res);
        leftView(node.right,level+1,res);
    }
}