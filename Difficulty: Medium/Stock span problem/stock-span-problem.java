class Pair{
    int val;
    int idx;
    
    Pair(int val,int idx){
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && st.peek().val <= arr[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                res.add(i+1);
            }else{
                res.add(i-st.peek().idx);
            }
            
            st.push(new Pair(arr[i],i));
        }
        
        return res;
    }
}