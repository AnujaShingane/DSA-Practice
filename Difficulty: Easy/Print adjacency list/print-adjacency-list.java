// User function Template for Java
class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0 ; i < V ; i++){
            res.add(new ArrayList<>());
        }
        
        for(int[] arr : edges){
            res.get(arr[0]).add(arr[1]);
            res.get(arr[1]).add(arr[0]);
        }
        
        return res;
    }
}