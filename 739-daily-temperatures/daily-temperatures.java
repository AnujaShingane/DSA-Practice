class Pair{
    int val;
    int index;

    Pair(int val , int index){
        this.val = val;
        this.index = index;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Pair> st = new Stack<>();

        for(int i = n-1 ; i >= 0 ; i--){
            if(st.isEmpty()){
                res[i] = 0;
            }else{
                while(!st.isEmpty() && st.peek().val <= temperatures[i]){
                    st.pop();
                    if(st.isEmpty())res[i] = 0;
                }
                if(!st.isEmpty() && st.peek().val > temperatures[i]){
                    res[i] = st.peek().index-i;
                }
            }
            st.push(new Pair(temperatures[i],i));
        }
        return res;
    }
}