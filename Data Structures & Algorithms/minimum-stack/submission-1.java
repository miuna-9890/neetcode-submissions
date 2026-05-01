class MinStack {
    Stack<Integer> stack;
    Stack<Integer> prefix;

    public MinStack() {
        stack = new Stack<>();
        prefix = new Stack<>();
        
    }
    
    public void push(int val) {
        stack.push(val);
        if (!prefix.isEmpty()) {
            prefix.push(Math.min(prefix.peek(), val));
        } else {
            prefix.push(val);
        }
    }
    
    public void pop() {
        stack.pop();
        prefix.pop();
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return prefix.peek();
    }
}
