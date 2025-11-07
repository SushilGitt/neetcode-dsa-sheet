class MinStack {

    ArrayDeque <Integer> stack;
    ArrayDeque <Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(val);
            minStack.push(val);
            return;
        }

        stack.push(val);
        if(minStack.peek() < val) {
            minStack.push(minStack.peek());
        }
        else {
            minStack.push(val);
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
/*

TC: O(1)
SC: O(2n) --> O(n)

*/