class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n ; i++){
            if(arr[i]<0)q.add(i);
            
            //start when window become size k
            if(i>=k-1){
                //if out of range remove
                while(!q.isEmpty() && q.peek()<i-k+1){
                    q.poll();
                }
                
                if(q.isEmpty())list.add(0);
                else list.add(arr[q.peek()]);
            }
        }
        return list;
    }
}