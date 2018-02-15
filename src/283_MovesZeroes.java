// For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//
// Note:
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.
//
// Time complexity: O(n) Space: O(1)

class Solution {
  public void moveZeroes(int[] nums) {
    int non_zero = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[non_zero++] = nums[i];
      }
    }
    for (int i = non_zero; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}
