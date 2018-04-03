class Solution {
  public boolean isValid(String s) {
    String left = "([{";
    String right = ")]}";
    Stack<Character> strStack = new Stack<>();

    for (int i = 0; i < s.length() ; i++ ) {
      char cur = s.charAt(i);
      if (left.indexOf(cur) != -1) {
        strStack.push(cur);
      } else {
        if (!strStack.isEmpty() &&
          strStack.peek() == left.charAt(right.indexOf(cur))) {
            strStack.pop();
        } else {
          return false;
        }
      }
    }
    return strStack.isEmpty();
  }
}
