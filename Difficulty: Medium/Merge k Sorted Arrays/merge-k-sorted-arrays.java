class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int[] arr : mat){
            for(int ele : arr){
                pq.add(ele);
            }
        }
        
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        
        return res;
    }
}