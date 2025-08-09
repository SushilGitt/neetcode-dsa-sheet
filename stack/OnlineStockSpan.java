class StockSpanner {

    ArrayDeque <int[]> s;

    public StockSpanner() {
        s = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;

        while(!s.isEmpty() && price >= s.peek()[0]) {
            span += s.peek()[1];
            s.poll();
        }
        s.push(new int[]{price, span});

        return span;
    }
}

/*

TC: O(1) amortized, O(n) worst case per call.
SC: O(n) worst case.

*/