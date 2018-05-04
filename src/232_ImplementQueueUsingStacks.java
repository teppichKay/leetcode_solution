class MyQueue {
    private Stack<Integer> realStack = new Stack<>();
    private Stack<Integer> tmp = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!realStack.isEmpty()) {
            int out = realStack.pop();
            tmp.push(out);
        }
        tmp.push(x);

        while (!tmp.isEmpty()) {
            int out2 = tmp.pop();
            realStack.push(out2);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return realStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return realStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return realStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
