class StockSpanner {
    
    /*
        We should have a stack of a pair of (current  price,
        maximum number of consecutive days)
        Since we don't have an access to the indicies.
    */
    Stack<int[]> s;
    
    public StockSpanner() {
        s = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!s.isEmpty() && price >= s.peek()[0]) { // If the current price is greater than stack peek.
            span += s.peek()[1];
            s.pop();
        }
        s.push(new int[]{price, span});
        return span;
    }
}

