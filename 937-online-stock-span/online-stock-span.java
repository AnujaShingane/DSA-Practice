class Pair {
    int val;
    int index;

    Pair(int val, int index) {
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
        day++; // Simulates the day index

        // Pop all elements less than or equal to current price
        while (!st.isEmpty() && st.peek().val <= price) {
            st.pop();
        }

        int span;
        if (st.isEmpty()) {
            span = day;  // Entire span from day 1
        } else {
            span = day - st.peek().index;
        }

        // Push current price and day index
        st.push(new Pair(price, day));
        return span;
    }
}
