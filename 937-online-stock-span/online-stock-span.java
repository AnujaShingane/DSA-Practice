class Pair{
    int val;
    int ind;

    Pair(int val, int ind){
        this.val = val;
        this.ind = ind;
    }
}

class StockSpanner {
    Stack<Pair> st;
    int curidx = 0;
    int idx = 0;
    int ans = -1;

    public StockSpanner() {
        st = new Stack<>();    
    }
    
    public int next(int price) {
        curidx++;
        while(!st.isEmpty() && st.peek().val<=price){
            st.pop();
        }

        if(st.isEmpty()){
            ans = curidx;
        }else{
            ans = curidx-st.peek().ind;
        }

        st.push(new Pair(price,curidx));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */