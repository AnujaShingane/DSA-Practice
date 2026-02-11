class Pair{
    int val;
    int idx;

    Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Pair> st = new Stack<>();

        for(int i = n-1 ; i>=0 ; i--){
            int curval = temperatures[i];
            int curidx = i;

            while(!st.isEmpty() && st.peek().val<=curval){
                st.pop();
            }

            if(st.isEmpty()){
                res[i]=0;
            }else{
                res[i]=st.peek().idx-curidx;
            }

            st.push(new Pair(curval,curidx));
        }

        return res;
    }
}