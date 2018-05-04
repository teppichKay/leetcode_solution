// For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

// Use Stack
// Time complexity: O(n) Space: O(n)
public int longestValidParantheses(String s) {
  Stack<int[]> stack = new Stack<int[]>();
  int res = 0;
  for (int i = 0; i < s.length(); i++) {
    if (s.charAt(i) == '(') {
      int[] a = {i, 0};
      stack.push(a);
      // else if this char is ')'
    } else {
      // if stack is empty or the top element in the stack is ')'
      if (stack.isEmpty() || stack.peek()[1] == 1) {
        int[] a = {i, 1};
        stack.push(a);
      } else {
        stack.pop();
        int cur = 0;
        // after stack pop, if stack becomes empty, count the length of validity
        if (stack.isEmpty()) {
          cur = i + 1;
        } else {
          cur = i - stack.peek()[0];
        }
        res = Math.max(res, cur);
      }
    }
  }
  return res;
}

// (())
// (  )
//
// stack:
// {0,0}
// {0,0} {1,0}
// {0,0} len= 2 - stack.peek()[0] = 2 - 0 = 2
//       len = i+1 = 3+1 = 4
