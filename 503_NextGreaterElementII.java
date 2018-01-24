// Input: [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2;
// The number 2 can't find next greater number;
// The second 1's next greater number needs to search circularly, which is also 2.
// Time complexity: O(n) Space: O(n)

class Solution {
  public int[] nextGreaterELements(int[] nums) {
    int[] res = new int[nums.length];
    Arrays.fill(res, -1);
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < 2 * nums.length ; i++ ) {
      int idx = i % nums.length;
      while (!stack.isEmpty() && nums[stack.peek()] < nums[idx]) {
        res[stack.pop()] = nums[idx];
      }
      if (i < nums.length) {
        stack.push(i);
      }
    }
    return res;
  }
}
