class Pair{
    int val;
    int index;

    Pair(int val , int index){
        this.val = val;
        this.index = index;
    }
}

class StockSpanner {
    Stack<Pair> st;
    int day;

    public StockSpanner() {
        st = new Stack<>();
        day = 0;
    }
    
    public int next(int price) {
        day++;

        while(!st.isEmpty() && st.peek().val <= price){
            st.pop();
        }

        int span;
        if(st.isEmpty()){
            span = day;
        }else{
            span = day - st.peek().index;
        }

        st.push(new Pair(price,day));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */