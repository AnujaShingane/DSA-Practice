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

class Pair{
    Node node;
    int line;
    
    Pair(Node node, int line){
        this.node = node;
        this.line = line;
    }
}

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            Node node = pair.node;
            int line = pair.line;
            
            if(!map.containsKey(line)){
                map.put(line,node.data);
            }
            
            if(node.left != null)q.offer(new Pair(node.left,line-1));
            if(node.right != null)q.offer(new Pair(node.right,line+1));
        }
        
        for(int key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}