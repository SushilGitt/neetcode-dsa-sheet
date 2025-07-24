class MyStack {
    ArrayDeque <Integer> dq;

    public MyStack() {
        dq = new ArrayDeque<>();
    }
    
    public void push(int x) {
        dq.push(x);
    }
    
    public int pop() {
        return dq.pop();
    }
    
    public int top() {
        return dq.peek();
    }
    
    public boolean empty() {
        return dq.isEmpty();
    }
}
/*

TC: O(1)
SC: O(n)

*/