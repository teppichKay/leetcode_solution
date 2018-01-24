class MyStack {
  private Queue<Integer> realQueue = new LinkedList<>();
  private Queue<Integer> tmp = new LinkedList<>();

  /** Push element x onto stack. **/
  public void push(int x) {
    tmp.offer(x);
    while(!realQueue.isEmpty()) {
      int out = realQueue.poll();
      tmp.offer(out);
    }
    // swap tmp and realQueue
    Queue tmp1 = tmp;
    tmp = realQueue;
    realQueue = tmp1;
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return realQueue.poll();
  }

  /** Get the top element. */
  public int top() {
      return realQueue.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
      return realQueue.isEmpty();
  }

  /**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
